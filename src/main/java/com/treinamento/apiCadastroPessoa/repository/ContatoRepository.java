package com.treinamento.apiCadastroPessoa.repository;

import com.treinamento.apiCadastroPessoa.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {}
