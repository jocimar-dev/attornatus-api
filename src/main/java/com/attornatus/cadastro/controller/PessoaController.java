package com.attornatus.cadastro.controller;

import com.attornatus.cadastro.entities.PessoaEntity;
import com.attornatus.cadastro.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping("/cria")
    public PessoaEntity criar(@RequestBody PessoaEntity pessoa) {
        return service.criar(pessoa);
    }

    @PutMapping("/salva")
    public PessoaEntity salvar(@RequestBody PessoaEntity pessoa) {
        return service.atualizar(pessoa);
    }

    @GetMapping("/{id}")
    public PessoaEntity buscar(@PathVariable Integer id) {
        return service.consultar(id);
    }

    @GetMapping
    public List<PessoaEntity> listar() {
        return service.listarPessoa();
    }


}

