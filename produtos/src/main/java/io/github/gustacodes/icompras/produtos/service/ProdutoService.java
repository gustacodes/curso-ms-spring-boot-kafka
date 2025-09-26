package io.github.gustacodes.icompras.produtos.service;

import io.github.gustacodes.icompras.produtos.model.Produto;
import io.github.gustacodes.icompras.produtos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> findById(final Long id) {
        return produtoRepository.findById(id);
    }
}
