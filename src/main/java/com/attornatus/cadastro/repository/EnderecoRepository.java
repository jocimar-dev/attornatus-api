package com.attornatus.cadastro.repository;

import com.attornatus.cadastro.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
    List<EnderecoEntity> findByPessoaId(Integer pessoaId);
}