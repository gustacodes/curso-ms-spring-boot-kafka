package io.github.gustacodes.icompras.pedidos.controller.mapper;

import io.github.gustacodes.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.gustacodes.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.gustacodes.icompras.pedidos.model.ItemPedido;
import io.github.gustacodes.icompras.pedidos.model.Pedido;
import io.github.gustacodes.icompras.pedidos.model.enums.StatusPedido;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.List;

import static java.time.LocalDateTime.now;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    ItemPedidoMapper ITEM_PEDIDO_MAPPER = Mappers.getMapper(ItemPedidoMapper.class);

    @Mapping(source = "itens", target = "itens", qualifiedByName = "mapItens")
    @Mapping(source = "dadosPagamentoDTO", target = "dadosPagamento")
    Pedido map(NovoPedidoDTO novoPedidoDTO);

    @Named("mapItens")
    default List<ItemPedido> mapItens(List<ItemPedidoDTO> dtos) {
        return dtos.stream().map(ITEM_PEDIDO_MAPPER::map).toList();
    }

    @AfterMapping
    default void afterMapping(@MappingTarget Pedido pedido) {
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setDataPedido(now());

        var total = calcularTotal(pedido);

        pedido.setTotal(total);
        pedido.getItens().forEach(item -> item.setPedido(pedido));
    }

    private static BigDecimal calcularTotal(Pedido pedido) {
        return pedido.getItens().stream().map(item ->
                item.getValorUnitario().multiply(BigDecimal.valueOf(item.getQuantidade()))
        ).reduce(BigDecimal.ZERO, BigDecimal::add).abs();
    }
}