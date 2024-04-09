package br.ecommerce.pedro.fase2javabackend.controllers;

import br.ecommerce.pedro.fase2javabackend.entities.Produto;
import br.ecommerce.pedro.fase2javabackend.repositories.ProdutoRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    //GET /produtos => retornar todos os produtos
    @GetMapping
    public List<Produto> listarTodosOsProdutos() {
        return repository.findAll();
    }

    // GET /produtos/id => retornar os produtos com id especificado
    @GetMapping("/{id}")
    public ResponseEntity <Produto> getProdutoPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST /produtos => adicionar um novo produto
    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto novo) {
        return repository.save(novo);
    }

    // DELETE /produtos/id => remover o produto com id especificado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> alterarProdutoPorId (@PathVariable Long id, @RequestBody Produto novosDados) {
        try {
            // 1 - Pegar um produto do banco pelo id
            Produto produtoVelho = repository.findById(id).get();

            // 2 - altero os dados
            produtoVelho.setNome(novosDados.getNome());
            produtoVelho.setDescricao(novosDados.getDescricao());

            // 3 - Salvo
            return new ResponseEntity<>(repository.save(produtoVelho), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
