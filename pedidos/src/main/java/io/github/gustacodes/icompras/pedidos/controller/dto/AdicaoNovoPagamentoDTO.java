package io.github.gustacodes.icompras.pedidos.controller.dto;

import io.github.gustacodes.icompras.pedidos.model.enums.TipoPagamento;

public record AdicaoNovoPagamentoDTO(Long codigoPedido, String dados, TipoPagamento tipoPagamento) {

}
