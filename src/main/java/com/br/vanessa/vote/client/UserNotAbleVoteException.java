package com.br.vanessa.vote.client;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class UserNotAbleVoteException extends IllegalArgumentException {

    public UserNotAbleVoteException() {
        super("Usuário não habilitado para votar");
    }
}
