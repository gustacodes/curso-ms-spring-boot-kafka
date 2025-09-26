package io.github.gustacodes.icompras.pedidos.controller.dto;

import java.math.BigDecimal;

public record ItemPedidoDTO(Long codigoProduto, int quantidade, BigDecimal valorUnitario) {
}
