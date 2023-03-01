package com.attornatus.cadastro.client;

import com.attornatus.cadastro.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "my-api-client", url = "https://viacep.com.br/ws/")
public interface BuscaCepClient {
    @GetMapping("{cep}/json/")
    Endereco buscaCep(@PathVariable("cep") String cep);
}
