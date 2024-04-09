package br.ecommerce.pedro.fase2javabackend.controllers;

import br.ecommerce.pedro.fase2javabackend.entities.Cliente;
import br.ecommerce.pedro.fase2javabackend.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    //GET /clientes => retornar todos os clientes
    @GetMapping
    public List<Cliente> listarTodosOsClientes() {
        return repository.findAll();
    }

    // GET /clientes/id => retornar os clientes com id especificado
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientePorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST /clientes => adicionar um novo cliente
    @PostMapping
    public Cliente adicionarCliente(@RequestBody Cliente novo) {
        return repository.save(novo);
    }

    // DELETE /clientes/id => remover o cliente com id especificado
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
    public ResponseEntity<Cliente> alterarClientePorId (@PathVariable Long id, @RequestBody Cliente novosDados) {
        try {
            // 1 - Pegar um cliente do banco pelo id
            Cliente clienteVelho = repository.findById(id).get();

            // 2 - altero os dados
            clienteVelho.setNome(novosDados.getNome());
            clienteVelho.setCpf(novosDados.getCpf());

            // 3 - Salvo
            return new ResponseEntity<>(repository.save(clienteVelho), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

