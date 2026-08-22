package com.TiagoLiberato.exe_padroes_de_projeto_spring.repository;

import com.TiagoLiberato.exe_padroes_de_projeto_spring.model.Endereco;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
    Optional<Endereco> findByCep(String cep);
}
