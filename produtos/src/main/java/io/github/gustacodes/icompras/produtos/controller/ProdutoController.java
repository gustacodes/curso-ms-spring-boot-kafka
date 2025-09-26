package io.github.gustacodes.icompras.produtos.controller;

import io.github.gustacodes.icompras.produtos.model.Produto;
import io.github.gustacodes.icompras.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> findById(@PathVariable Long codigo) {
        return produtoService.findById(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
