package com.br.vanessa.vote.controller.response;

import com.br.vanessa.vote.model.Vote;
import com.br.vanessa.vote.model.VoteEnum;
import io.swagger.annotations.ApiModelProperty;

public class VoteResponse {

    @ApiModelProperty(example = "Identificador único da pauta")
    private Long idVote;
    @ApiModelProperty(example = "Identificador único da sessão")
    private Long idSession;
    @ApiModelProperty(example = "Identificador do tipo CPF do usuário")
    private String cpf;
    @ApiModelProperty(example = "Opção de voto")
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
