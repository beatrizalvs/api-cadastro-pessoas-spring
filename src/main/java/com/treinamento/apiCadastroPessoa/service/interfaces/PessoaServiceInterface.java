package com.treinamento.apiCadastroPessoa.service.interfaces;

import com.treinamento.apiCadastroPessoa.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaServiceInterface {
    Pessoa save(Pessoa pessoa);
    Optional<Pessoa> getById(Long id);
    List<Pessoa> getAll();
    Pessoa update(Pessoa pessoa);
    void delete(Long id);
}
