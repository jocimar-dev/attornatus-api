package com.attornatus.cadastro.service;

import com.attornatus.cadastro.model.Pessoa;
import com.attornatus.cadastro.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Pessoa criar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa atualizar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa consultar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Pessoa> listarPessoa() {
        return repository.findAll();
    }
}
