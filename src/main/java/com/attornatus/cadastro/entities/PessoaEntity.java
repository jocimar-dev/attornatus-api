package com.attornatus.cadastro.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.UUID;

@Entity
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = UUID)
    private Integer id;
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataNascimento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", nullable = false)
    private EnderecoEntity enderecoEntity;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public EnderecoEntity getEndereco() {
        return enderecoEntity;
    }

    public PessoaEntity(Integer id, String nome, LocalDate dataNascimento, EnderecoEntity enderecoEntity) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecoEntity = enderecoEntity;
    }

    public PessoaEntity() {}
}
