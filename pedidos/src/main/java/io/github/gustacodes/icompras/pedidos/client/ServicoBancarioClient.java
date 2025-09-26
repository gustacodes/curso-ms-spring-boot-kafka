package io.github.gustacodes.icompras.pedidos.client;

import io.github.gustacodes.icompras.pedidos.model.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ServicoBancarioClient {

    public String solicitarPagamento(Pedido pedido) {
        log.info("Solicitando pagamento para o pedido de código {} ", pedido.getCodigo());
        return UUID.randomUUID().toString();
    }
}
