package io.github.gustacodes.icompras.clientes.repository;

import io.github.gustacodes.icompras.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
