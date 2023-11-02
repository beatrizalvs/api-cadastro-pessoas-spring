package com.treinamento.apiCadastroPessoa.repository;

import com.treinamento.apiCadastroPessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}
