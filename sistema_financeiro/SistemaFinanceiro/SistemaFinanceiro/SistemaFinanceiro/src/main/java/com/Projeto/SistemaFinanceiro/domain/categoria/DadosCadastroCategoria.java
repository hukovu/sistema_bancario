package com.Projeto.SistemaFinanceiro.domain.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoria(
        @NotBlank
        String nome
) {
}
