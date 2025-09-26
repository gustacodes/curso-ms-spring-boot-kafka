package io.github.gustacodes.icompras.pedidos.controller;

import io.github.gustacodes.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.gustacodes.icompras.pedidos.controller.mapper.PedidoMapper;
import io.github.gustacodes.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final PedidoMapper mapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO novoPedidoDTO) {
        var pedido = mapper.map(novoPedidoDTO);
        var novoPedido = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok().body(novoPedido.getCodigo());
    }
}
