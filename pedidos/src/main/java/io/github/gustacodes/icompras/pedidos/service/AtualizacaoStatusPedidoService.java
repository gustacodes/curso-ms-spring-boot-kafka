package io.github.gustacodes.icompras.pedidos.service;

import io.github.gustacodes.icompras.pedidos.model.enums.StatusPedido;
import io.github.gustacodes.icompras.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoService {

    private final PedidoRepository pedidoRepository;

    public void atualizarStatus(Long codigo, StatusPedido status, String urlNotaFiscal, String rastreio) {

    }

}
