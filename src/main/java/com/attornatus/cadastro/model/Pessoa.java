package com.attornatus.cadastro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataNascimento;
    @OneToMany(mappedBy = "endereco_id", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
