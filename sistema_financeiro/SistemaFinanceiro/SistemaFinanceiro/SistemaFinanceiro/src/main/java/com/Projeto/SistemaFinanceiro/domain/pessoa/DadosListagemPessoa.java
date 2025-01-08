package com.Projeto.SistemaFinanceiro.domain.pessoa;

public record DadosListagemPessoa(Long id, String nome, Boolean Pessoa) {

    public DadosListagemPessoa(com.Projeto.SistemaFinanceiro.domain.model.Pessoa Pessoa) {
        this(Pessoa.getId(), Pessoa.getNome(), Pessoa.getAtivo());
    }
}
