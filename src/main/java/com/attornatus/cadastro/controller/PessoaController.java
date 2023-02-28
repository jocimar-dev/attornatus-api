package com.attornatus.cadastro.controller;

import com.attornatus.cadastro.model.Pessoa;
import com.attornatus.cadastro.service.PessoaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @PersistenceContext
    private EntityManager manager;
    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        return service.criar(pessoa);
    }

    @PutMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return service.atualizar(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa buscar(@PathVariable Long id) {
        return service.consultar(id);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return service.listarPessoa();
    }

}

