package com.attornatus.cadastro.service;

import com.attornatus.cadastro.entities.EnderecoEntity;
import com.attornatus.cadastro.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    public EnderecoEntity criar(EnderecoEntity endereco) {
        return repository.save(endereco);
    }

    public List<EnderecoEntity> listarEndereco(Integer id) {
        return repository.findByPessoaId(id);
    }

    public void definirEnderecoPrincipal(Integer enderecoId) {
        Optional<EnderecoEntity> endereco = repository.findById(enderecoId);
        if (endereco.isPresent()) {
            var enderecoPrincipal = endereco.get();
            var enderecosList = repository.findByPessoaId(enderecoPrincipal.getPessoa().getId());
            enderecosList.forEach(e -> e.setPrincipal(false));
            enderecoPrincipal.setPrincipal(true);
            repository.save(enderecoPrincipal);
        }
    }
}
