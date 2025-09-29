package io.github.gustacodes.icompras.pedidos.client.representation;

public record ClienteRepresentation(
        Long codigo,
        String nome,
        String cpf,
        String logradouro,
        String numero) {
}
