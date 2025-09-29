package io.github.gustacodes.icompras.pedidos.controller;

import io.github.gustacodes.icompras.pedidos.controller.dto.RecebimentoCallbackPagamentoDTO;
import io.github.gustacodes.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos/callback-pagamentos")
public class RecebimentoCallbackPagamentoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Object> atualizarStatusPagamento(
            @RequestBody RecebimentoCallbackPagamentoDTO body,
            @RequestHeader(required = true, name = "apiKey") String apiKey) {
        pedidoService.atualizarStatusPagamento(
                body.codigo(),
                body.chavePagamento(),
                body.status(),
                body.observacoes());

        return ResponseEntity.ok().build();
    }
}
