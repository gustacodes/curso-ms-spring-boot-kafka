package io.github.gustacodes.icompras.produtos.repository;

import io.github.gustacodes.icompras.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
