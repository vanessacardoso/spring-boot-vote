package com.br.vanessa.vote.controller.request;

import com.br.vanessa.vote.model.VoteEnum;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class VoteRequest {

    @ApiModelProperty(example = "Identificador único da sessão")
    @NotNull
    private Long idSession;
    @ApiModelProperty(example = "Identificador do tipo CPF do usuário")
    @NotNull
    private String cpf;
    @ApiModelProperty(example = "Opção de voto")
    @NotNull
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
