package io.github.gustacodes.icompras.faturamento.subscriber;

import io.github.gustacodes.icompras.faturamento.model.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GeradorNotaFiscalService {

    public void gerar(Pedido pedido) {
        log.info("Gerada nota fiscal para o pedido {} ", pedido.codigo());
    }
}
