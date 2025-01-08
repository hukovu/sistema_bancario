package com.Projeto.SistemaFinanceiro.domain.categoria;

import com.Projeto.SistemaFinanceiro.domain.model.Categoria;

public record DadosListagemCategoria(Long id, String nome) {

    public DadosListagemCategoria(Categoria categoria) {
        this(categoria.getId(), categoria.getNome());
    }
}
