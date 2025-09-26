package io.github.gustacodes.icompras.pedidos.controller.dto;

import io.github.gustacodes.icompras.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(String dados, TipoPagamento tipoPagamento) {
}
