package com.attornatus.cadastro.service;

import com.attornatus.cadastro.entities.PessoaEntity;
import com.attornatus.cadastro.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public PessoaEntity criar(PessoaEntity pessoa) {
        return repository.save(pessoa);
    }

    public PessoaEntity atualizar(PessoaEntity pessoa) {
        return repository.save(pessoa);
    }

    public PessoaEntity consultar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<PessoaEntity> listarPessoa() {
        return repository.findAll();
    }
}
