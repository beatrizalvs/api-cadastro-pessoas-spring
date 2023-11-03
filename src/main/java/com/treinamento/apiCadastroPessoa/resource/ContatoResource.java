package com.treinamento.apiCadastroPessoa.resource;

import com.treinamento.apiCadastroPessoa.model.Contato;
import com.treinamento.apiCadastroPessoa.model.Pessoa;
import com.treinamento.apiCadastroPessoa.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/contato")
public class ContatoResource {

    private ContatoService contatoService;

    @Autowired
    public ContatoResource(ContatoService contatoService){
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<Contato> create(@RequestBody Contato contato){
        return new ResponseEntity<>(contatoService.update(contato), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contato>> getById(@PathVariable Long id){
        Optional<Contato> contato = contatoService.getById(id);
        if (contato == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contato);
    }

    @GetMapping("/{pessoa_id}/contatos")
    public ResponseEntity<Optional<Contato>> getByPessoaId(@PathVariable Long pessoa_id){
        Optional<Contato> contato = contatoService.getById(pessoa_id);
        if (contato == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contato);
    }

    @PutMapping
    public ResponseEntity<Contato> update(@RequestBody Contato contato){
        return new ResponseEntity<>(contatoService.update(contato), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
