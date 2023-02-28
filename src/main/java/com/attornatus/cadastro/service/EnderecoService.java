package com.attornatus.cadastro.service;

import com.attornatus.cadastro.model.Endereco;
import com.attornatus.cadastro.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public Endereco criar(Endereco endereco) {
        return repository.save(endereco);
    }

    public List<Endereco> listarEndereco(Long id) {
        return repository.findByPessoaId(id);
    }

    public void definirEnderecoPrincipal(Long enderecoId) {
        Optional<Endereco> endereco = repository.findById(enderecoId);
        if (endereco.isPresent()) {
            var enderecoPrincipal = endereco.get();
            var enderecosList = repository.findByPessoaId(enderecoPrincipal.getPessoa().getId());
            enderecosList.forEach(e -> e.setPrincipal(false));
            enderecoPrincipal.setPrincipal(true);
            repository.save(enderecoPrincipal);
        }
    }
}
