package com.treinamento.apiCadastroPessoa.service;

import com.treinamento.apiCadastroPessoa.exception.ResourceNotFoundException;
import com.treinamento.apiCadastroPessoa.model.Contato;
import com.treinamento.apiCadastroPessoa.repository.ContatoRepository;
import com.treinamento.apiCadastroPessoa.service.interfaces.ContatoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService implements ContatoServiceInterface{

    private ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository){
        this.contatoRepository = contatoRepository;
    }

    @Override
    public Contato save(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public Optional<Contato> getById(Long id) {
        return contatoRepository.findById(id);
    }

    @Override
    public List<Contato> getAll() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato update(Contato contato) {
        Optional<Contato> upContato = contatoRepository.findById(contato.getId());

        if (upContato.isPresent()){
            Contato newContato = upContato.get();
            newContato.setPessoa(contato.getPessoa());
            newContato.setContato(contato.getContato());
            return contatoRepository.save(newContato);
        }
        return contato;
    }

    @Override
    public void delete(Long id) {
        contatoRepository.deleteById(id);
    }

    @Override
    public Contato addNovoContato(Long id, String contatos) {
        return contatoRepository.findById(id)
                .map(contato -> {
                    contato.setContato(contato.getContato() + " " + contatos);
                    return contatoRepository.save(contato);
                }).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
    }

}
