package com.Projeto.SistemaFinanceiro.domain.model;

import com.Projeto.SistemaFinanceiro.domain.categoria.DadosAtualizacaoCategoria;
import com.Projeto.SistemaFinanceiro.domain.categoria.DadosCadastroCategoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Categoria")
@Table(name = "categoria")
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean ativo = true;


    public Categoria(DadosCadastroCategoria dados) {
        this.nome = dados.nome();
    }

    public void atualizarInformacoesCategoria(DadosAtualizacaoCategoria dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }

    }

    public void excluir() {
        this.ativo = false;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
