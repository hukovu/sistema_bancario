package com.Projeto.SistemaFinanceiro.domain.pessoa;
import jakarta.validation.constraints.NotNull;
import com.Projeto.SistemaFinanceiro.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPessoa(

        @NotNull
        Long id,
        String nome,
        DadosEndereco endereco) {

}