package com.TiagoLiberato.exe_padroes_de_projeto_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ClientAlreadyExists extends RuntimeException {
    public ClientAlreadyExists(String message) {
        super(message);
    }
}
