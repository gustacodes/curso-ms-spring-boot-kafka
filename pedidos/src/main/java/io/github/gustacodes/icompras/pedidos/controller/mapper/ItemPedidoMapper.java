package io.github.gustacodes.icompras.pedidos.controller.mapper;

import io.github.gustacodes.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.gustacodes.icompras.pedidos.model.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    ItemPedido map(ItemPedidoDTO itemPedidoDTO);
}
