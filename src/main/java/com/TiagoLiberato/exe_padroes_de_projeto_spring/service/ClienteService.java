package com.TiagoLiberato.exe_padroes_de_projeto_spring.service;

import com.TiagoLiberato.exe_padroes_de_projeto_spring.model.Cliente;

import java.util.Optional;

//FACADE: Usa o padrão de projeto fornecendo uma interface simples que abstrai uma classe que implementa os métodos completos.
public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Optional<Cliente> buscarPorId(Long Id);

    void inserir(Cliente cliente);

    void atualizar(Long Id, Cliente cliente);

    void deletar(Long Id);

}
