package io.github.gustacodes.icompras.faturamento.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.gustacodes.icompras.faturamento.model.Pedido;
import io.github.gustacodes.icompras.faturamento.publisher.representation.AtualizacaoStatusPedido;
import io.github.gustacodes.icompras.faturamento.publisher.representation.StatusPedido;
import kotlin.internal.Exact;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FaturamentoPublisher {

    private final KafkaTemplate kafkaTemplate;
    private final ObjectMapper mapper;

    @Value("${icompras.config.kafka.topics.pedidos-faturados}")
    private String topico;

    public void publicar(Pedido pedido, String urlNotaFiscal) {
        try {
            var representation = new AtualizacaoStatusPedido(pedido.codigo(), StatusPedido.FATURADO, urlNotaFiscal);
            String json = mapper.writeValueAsString(representation);
            kafkaTemplate.send(topico, "dados", json);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
