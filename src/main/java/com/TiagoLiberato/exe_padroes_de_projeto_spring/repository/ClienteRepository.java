package com.TiagoLiberato.exe_padroes_de_projeto_spring.repository;

import com.TiagoLiberato.exe_padroes_de_projeto_spring.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    public boolean existsByCpf(String cpf);
}
