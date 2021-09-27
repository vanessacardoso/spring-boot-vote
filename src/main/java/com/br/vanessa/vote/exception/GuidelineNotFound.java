package com.br.vanessa.vote.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class GuidelineNotFound extends IllegalArgumentException {

    public GuidelineNotFound() {
        super("Não foi encontrada a pauta com o id informado");
    }
}
