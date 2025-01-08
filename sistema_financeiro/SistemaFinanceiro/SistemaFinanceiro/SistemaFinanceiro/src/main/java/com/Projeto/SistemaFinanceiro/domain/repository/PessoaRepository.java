package com.Projeto.SistemaFinanceiro.domain.repository;

import com.Projeto.SistemaFinanceiro.domain.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Page<Pessoa> findByAtivoTrue(Pageable paginacao);
}