package com.TiagoLiberato.exe_padroes_de_projeto_spring.service;

import com.TiagoLiberato.exe_padroes_de_projeto_spring.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "viaCep", url = "https://viacep.com.br/ws" )
public interface ViaCepService {

    @GetMapping("/{cep}/json")
    Endereco buscarEndereco(@PathVariable("cep") String cep);
}
