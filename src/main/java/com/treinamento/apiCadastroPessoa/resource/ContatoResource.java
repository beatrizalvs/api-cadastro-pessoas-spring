package com.treinamento.apiCadastroPessoa.resource;

import com.treinamento.apiCadastroPessoa.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contato")
public class ContatoResource {

    private ContatoService contatoService;

    @Autowired
    public ContatoResource(ContatoService contatoService){
        this.contatoService = contatoService;
    }
}
