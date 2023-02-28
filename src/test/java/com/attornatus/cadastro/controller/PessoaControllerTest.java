package com.attornatus.cadastro.controller;

import com.attornatus.cadastro.Application;
import com.attornatus.cadastro.model.Endereco;
import com.attornatus.cadastro.model.Pessoa;
import com.attornatus.cadastro.repository.PessoaRepository;
import com.attornatus.cadastro.service.EnderecoService;
import com.attornatus.cadastro.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@AutoConfigureMockMvc
//@ActiveProfiles("test")
//@SpringBootTest(classes = Application.class)
class PessoaControllerTest {

    ///@Autowired
    private MockMvc mockMvc;

    @MockBean
    private PessoaService pessoaService;

//    @MockBean
//    private EnderecoService enderecoService;
//
//    @Captor
//    private ArgumentCaptor<Pessoa> pessoaCaptor;
//
//    @Captor
//    private ArgumentCaptor<Endereco> enderecoCaptor;

   // @Test
    void criar_deveRetornarPessoaCriada() throws Exception {
        var pessoa = new Pessoa();
        pessoa.setNome("Jocimar Neres");
        pessoa.setDataNascimento(LocalDate.of(1988, 11, 5));
        when(pessoaService.criar(any(Pessoa.class))).thenReturn(pessoa);

        var result = mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Jocimar Neres\",\"dataNascimento\":\"1988-11-05\"}"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn();

        var response = new ObjectMapper().readValue(result.getResponse().getContentAsString(), Pessoa.class);
        assertEquals(pessoa.getNome(), response.getNome());
        assertEquals(pessoa.getDataNascimento(), response.getDataNascimento());
        assertNotNull(response.getId());
    }
    //@Test
    void atualizar_deveRetornarPessoaAtualizada() throws Exception {
        var pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Fulano");
        pessoa.setDataNascimento(LocalDate.of(1990, 1, 1));
        when(pessoaService.atualizar(any(Pessoa.class))).thenReturn(pessoa);

        var result = mockMvc.perform(MockMvcRequestBuilders.put("/pessoas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Jocimar Neres Silva\",\"dataNascimento\":\"1998-11-05\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Pessoa response = new ObjectMapper().readValue(result.getResponse().getContentAsString(), Pessoa.class);
        assertEquals(pessoa.getNome(), response.getNome());
        assertEquals(pessoa.getDataNascimento(), response.getDataNascimento());
        assertEquals(pessoa.getId(), response.getId());
    }
}