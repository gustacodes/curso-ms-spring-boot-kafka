package io.github.gustacodes.icompras.pedidos.client.representation;

public record ClienteRepresentation(
        Long codigo,
        String nome,
        String email,
        String telefone,
        String cpf,
        String bairro,
        String logradouro,
        String numero) {
}
