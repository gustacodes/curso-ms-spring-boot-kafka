package io.github.gustacodes.icompras.pedidos.subscriber.representation;

import io.github.gustacodes.icompras.pedidos.model.enums.StatusPedido;

public record AtualizacaoStatusPedidoRepresentation(
        Long codigo,
        StatusPedido status,
        String urlNotaFiscal,
        String codigoRastreio
) {
}
