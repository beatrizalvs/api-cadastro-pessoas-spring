package com.treinamento.apiCadastroPessoa.records;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public record PessoaRecord(Long id, String nome, String malaDireta ) {

}
