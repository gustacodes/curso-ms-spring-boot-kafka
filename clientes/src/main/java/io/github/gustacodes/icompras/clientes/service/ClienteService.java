package io.github.gustacodes.icompras.clientes.service;

import io.github.gustacodes.icompras.clientes.model.Cliente;
import io.github.gustacodes.icompras.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(final Long codigo) {
        return clienteRepository.findById(codigo);
    }
}
