package com.attornatus.cadastro.controller;

import com.attornatus.cadastro.entities.EnderecoEntity;
import com.attornatus.cadastro.entities.PessoaEntity;
import com.attornatus.cadastro.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa/{pessoa_id}")
public class EnderecoController  {

    @Autowired
    private EnderecoService service;

    @PostMapping("/cria_endereco")
    public EnderecoEntity criar(@PathVariable Integer pessoaId,
                                 @RequestBody EnderecoEntity endereco) {
        var pessoa = new PessoaEntity();
        pessoa.setId(pessoaId);
        endereco.setPessoa(pessoa);
        return service.criar(endereco);
    }

    @GetMapping("/busca_endereco")
    public List<EnderecoEntity> listar(@PathVariable Integer pessoaId) {
        return service.listarEndereco(pessoaId);
    }

    @PutMapping("/endereco_principal")
    public void defineEnderecoPrincipal(@PathVariable Integer endereco) {
        service.definirEnderecoPrincipal(endereco);
    }

}
