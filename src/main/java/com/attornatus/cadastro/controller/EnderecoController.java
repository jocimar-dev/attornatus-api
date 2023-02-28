package com.attornatus.cadastro.controller;

import com.attornatus.cadastro.model.Endereco;
import com.attornatus.cadastro.model.Pessoa;
import com.attornatus.cadastro.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa/{pessoaId}")
public class EnderecoController  {

    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @PostMapping
    public Endereco criar(@PathVariable Long pessoaId,
                          @RequestBody Endereco endereco) {
        var pessoa = new Pessoa();
        pessoa.setId(pessoaId);
        endereco.setPessoa(pessoa);
        return service.criar(endereco);
    }

    @GetMapping
    public List<Endereco> listar(@PathVariable Long pessoaId) {
        return service.listarEndereco(pessoaId);
    }

    @PutMapping
    public void enderecoPrincipal(@PathVariable Long pessoaId) {
        service.definirEnderecoPrincipal(pessoaId);
    }

}
