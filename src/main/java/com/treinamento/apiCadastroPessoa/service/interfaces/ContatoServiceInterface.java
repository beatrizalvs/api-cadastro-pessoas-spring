package com.treinamento.apiCadastroPessoa.service.interfaces;

import com.treinamento.apiCadastroPessoa.model.Contato;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Optional;

public interface ContatoServiceInterface {
    Contato save(Contato contato);
    Optional<Contato> getById(Long id);
    List<Contato> getAll();
    Contato update(Contato contato);
    void delete(Long id);
    Contato addNovoContato(Long id, String contato);

}
