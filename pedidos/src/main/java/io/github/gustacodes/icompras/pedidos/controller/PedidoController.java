package io.github.gustacodes.icompras.pedidos.controller;

import io.github.gustacodes.icompras.pedidos.controller.dto.AdicaoNovoPagamentoDTO;
import io.github.gustacodes.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.gustacodes.icompras.pedidos.controller.mapper.PedidoMapper;
import io.github.gustacodes.icompras.pedidos.model.ErroResposta;
import io.github.gustacodes.icompras.pedidos.model.exception.ItemNaoEncontradoException;
import io.github.gustacodes.icompras.pedidos.model.exception.ValidationException;
import io.github.gustacodes.icompras.pedidos.publisher.representation.DetalhePedidoRepresentation;
import io.github.gustacodes.icompras.pedidos.publisher.DetalhePedidoMapper;
import io.github.gustacodes.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final PedidoMapper mapper;
    private final DetalhePedidoMapper detalhePedidoMapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO novoPedidoDTO) {
        try {
            var pedido = mapper.map(novoPedidoDTO);
            var novoPedido = pedidoService.criarPedido(pedido);
            return ResponseEntity.ok().body(novoPedido.getCodigo());
        } catch (ValidationException e) {
            var erro = new ErroResposta("Erro de validação", e.getField(), e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PostMapping("/pagamentos")
    public ResponseEntity<Object> adicionarNovoPagamento(@RequestBody AdicaoNovoPagamentoDTO adicaoNovoPagamentoDTO) {
        try {
            pedidoService.adicionarNovoPagamento(
                    adicaoNovoPagamentoDTO.codigoPedido(),
                    adicaoNovoPagamentoDTO.dados(),
                    adicaoNovoPagamentoDTO.tipoPagamento());
            return ResponseEntity.noContent().build();
        } catch (ItemNaoEncontradoException e) {
            var error = new ErroResposta("Item não encontrado", "codigoPedido", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<DetalhePedidoRepresentation> obterDetalhesPedido(@PathVariable Long codigo) {
        return pedidoService.carregarDadosCompletosPedido(codigo)
                .map(detalhePedidoMapper::map)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}