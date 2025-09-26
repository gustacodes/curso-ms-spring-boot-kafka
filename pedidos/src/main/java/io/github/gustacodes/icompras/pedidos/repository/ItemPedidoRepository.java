package io.github.gustacodes.icompras.pedidos.repository;

import io.github.gustacodes.icompras.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
