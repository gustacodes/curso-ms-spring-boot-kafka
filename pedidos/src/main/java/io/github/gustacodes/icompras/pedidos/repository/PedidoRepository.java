package io.github.gustacodes.icompras.pedidos.repository;

import io.github.gustacodes.icompras.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
