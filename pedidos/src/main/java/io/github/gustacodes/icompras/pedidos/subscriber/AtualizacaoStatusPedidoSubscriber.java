package io.github.gustacodes.icompras.pedidos.subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.gustacodes.icompras.pedidos.service.AtualizacaoStatusPedidoService;
import io.github.gustacodes.icompras.pedidos.subscriber.representation.AtualizacaoStatusPedidoRepresentation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoSubscriber {

    private final AtualizacaoStatusPedidoService service;
    private final ObjectMapper mapper;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = {
                    "${icompras.config.kafka.topics.pedidos-faturados}",
                    "${icompras.config.kafka.topics.pedidos-enviados}"
            })
    public void receberAtualizacao(String payload) {
        try {
            log.info("Recebendo atualização de status: {} ", payload);
            var atualizacaoStatus = mapper.readValue(
                    payload,
                    AtualizacaoStatusPedidoRepresentation.class);

            service.atualizarStatus(
                    atualizacaoStatus.codigo(),
                    atualizacaoStatus.status(),
                    atualizacaoStatus.urlNotaFiscal(),
                    atualizacaoStatus.codigoRastreio()
            );
            log.info("Pedido atualizado com sucesso!");
        } catch (Exception e) {
            log.error("Erro ao atualizar status pedido {} ", e.getMessage());
        }
    }

}
