package com.br.vanessa.vote.controller.response;

import com.br.vanessa.vote.model.Vote;
import com.br.vanessa.vote.model.VoteEnum;

public class VoteResponse {

    private Long idVote;
    private Long idSession;
    private String cpf;
    private VoteEnum vote;

    public VoteResponse(Vote vote) {
        this.idVote = vote.getId();
        this.idSession = vote.getIdSession();
        this.cpf = vote.getCpf();
        this.vote = vote.getVote();
    }

    public Long getIdVote() {
        return idVote;
    }

    public void setIdVote(Long idVote) {
        this.idVote = idVote;
    }

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
