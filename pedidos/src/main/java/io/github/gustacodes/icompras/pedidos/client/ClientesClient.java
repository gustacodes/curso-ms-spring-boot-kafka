package io.github.gustacodes.icompras.pedidos.client;

import io.github.gustacodes.icompras.pedidos.client.representation.ClienteRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "clientes", url = "${icompras.pedidos.clients.clientes.url}")
public interface ClientesClient {

    @GetMapping("/{codigo}")
    ResponseEntity<ClienteRepresentation> findById(@PathVariable Long codigo);
}
