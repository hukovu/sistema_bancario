package com.Projeto.SistemaFinanceiro.controller;

import com.Projeto.SistemaFinanceiro.domain.categoria.DadosAtualizacaoCategoria;
import com.Projeto.SistemaFinanceiro.domain.categoria.DadosCadastroCategoria;
import com.Projeto.SistemaFinanceiro.domain.categoria.DadosDetalhamentoCategoria;
import com.Projeto.SistemaFinanceiro.domain.categoria.DadosListagemCategoria;
import com.Projeto.SistemaFinanceiro.domain.model.Categoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.Projeto.SistemaFinanceiro.domain.repository.CategoriaRepository;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCategoria dados, UriComponentsBuilder uriBuilder) {
        var categoria = new Categoria(dados);
        categoriaRepository.save(categoria);
        var uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCategoria(categoria));
    }



    @GetMapping
    public ResponseEntity<Page<DadosListagemCategoria>>
    listar (@PageableDefault(size = 10, sort = {"nome"}) Pageable
                    paginacao ){
        var page = categoriaRepository.findByAtivoTrue(paginacao).map(DadosListagemCategoria::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoCategoria dados) {
        var categoria = categoriaRepository.getReferenceById(id);
        categoria.atualizarInformacoesCategoria(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var categoria = categoriaRepository.getReferenceById(id);
        categoria.excluir();

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var categoria = categoriaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));
    }

}
