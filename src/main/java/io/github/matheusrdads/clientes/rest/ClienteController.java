package io.github.matheusrdads.clientes.rest;

import io.github.matheusrdads.clientes.model.entity.Cliente;
import io.github.matheusrdads.clientes.model.repository.ClienteRepository;
import org.jboss.jandex.VoidType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)                      //devolve 201
    public Cliente salvar(@RequestBody Cliente cliente){     //informando que "cliente" ira receber um objeto JSON(converte de objeto JSON para objeto do tipo cliente)
        return repository.save(cliente);                     //salva o cliente e retorna ele salvo
    }

    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        repository
                .findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
