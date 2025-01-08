package com.Projeto.SistemaFinanceiro.domain.pessoa;

import com.Projeto.SistemaFinanceiro.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPessoa(

        @NotBlank
        String nome,
        @NotNull @Valid DadosEndereco endereco
) {
}
