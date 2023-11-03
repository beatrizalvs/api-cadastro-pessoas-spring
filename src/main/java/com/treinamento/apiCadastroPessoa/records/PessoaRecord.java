package com.treinamento.apiCadastroPessoa.records;

import lombok.Builder;

@Builder
public record PessoaRecord(Long id, String nome, String malaDireta ) {

}
