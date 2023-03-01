package com.attornatus.cadastro.service;

import com.attornatus.cadastro.client.BuscaCepClient;
import com.attornatus.cadastro.model.Endereco;
import com.attornatus.cadastro.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    private final EnderecoRepository repository;
    private final BuscaCepClient client;

    public EnderecoService(EnderecoRepository repository, BuscaCepClient client) {
        this.repository = repository;
        this.client = client;
    }

    public Endereco criar(Endereco endereco) {
        return repository.save(endereco);
    }

    public List<Endereco> listarEndereco(Long id) {
        return repository.findByPessoaId(id);
    }

    public void definirEnderecoPrincipal(String enderecoId) {
        Optional<Endereco> endereco = Optional.ofNullable(client.buscaCep(enderecoId));
        if (endereco.isPresent()) {
            var enderecoPrincipal = endereco.get();
            var enderecosList = Collections.singletonList(enderecoPrincipal);
            for (Endereco e : enderecosList) {
                e.setPrincipal(false);
                repository.save(e);
            }
            enderecoPrincipal.setPrincipal(true);
            repository.save(enderecoPrincipal);
        }
    }
}
