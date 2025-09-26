package io.github.gustacodes.icompras.pedidos.model;

import io.github.gustacodes.icompras.pedidos.model.enums.TipoPagamento;
import lombok.Data;

@Data
public class DadosPagamento {
    private String dados;
    private TipoPagamento tipoPagamento;
}
