package com.br.vanessa.vote.controller.request;

import com.br.vanessa.vote.model.VoteEnum;

public class VoteRequest {

    private Long idSession;
    private String cpf;
    private VoteEnum vote;

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public VoteEnum getVote() {
        return vote;
    }

    public void setVote(VoteEnum vote) {
        this.vote = vote;
    }
}
