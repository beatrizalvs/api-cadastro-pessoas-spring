package com.treinamento.apiCadastroPessoa.resource;

import com.treinamento.apiCadastroPessoa.exception.ResourceNotFoundException;
import com.treinamento.apiCadastroPessoa.model.Pessoa;
import com.treinamento.apiCadastroPessoa.records.PessoaRecord;
import com.treinamento.apiCadastroPessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaResource {

    private PessoaService pessoaService;

    @Autowired
    public PessoaResource(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
        Pessoa newPessoa = pessoaService.save(pessoa);
        if (pessoa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(newPessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Long id){
        Optional<Pessoa> pessoas = pessoaService.getById(id);
        if (pessoas == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/maladireta/{id}")
    public PessoaRecord getMalaDiretaPessoas(@PathVariable Long id){
        return pessoaService.getById(id)
                .map(pessoas -> {
                    return new PessoaRecord(
                            pessoas.getId(),
                            pessoas.getNome(),
                            pessoas.getEndereco() + " - CEP: " + pessoas.getCep() + " " + pessoas.getCidade() + "/" + pessoas.getUf()
                    );
                }).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas(){
        List<Pessoa> pessoas = pessoaService.getAll();
        if (pessoas == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pessoas);
    }

    @PutMapping
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
        Pessoa newPessoa = pessoaService.update(pessoa);
        if (newPessoa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newPessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
