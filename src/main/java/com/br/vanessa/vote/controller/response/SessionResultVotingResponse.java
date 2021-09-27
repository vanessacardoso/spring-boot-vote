package com.br.vanessa.vote.controller.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import java.util.Objects;

@Builder
public class SessionResultVotingResponse {

    @ApiModelProperty(example = "Identificador único da sessão")
    private Long idSession;
    @ApiModelProperty(example = "Quantidade total de votos SIM")
    private Long voteYes;
    @ApiModelProperty(example = "Quantidade total de votos NÃO")
    private Long voteNo;
    @ApiModelProperty(example = "Quantidade total de votos")
    private Long totalVotes;

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }

    public Long getVoteYes() {
        return voteYes;
    }

    public void setVoteYes(Long voteYes) {
        this.voteYes = voteYes;
    }

    public Long getVoteNo() {
        return voteNo;
    }

    public void setVoteNo(Long voteNo) {
        this.voteNo = voteNo;
    }

    public Long getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Long totalVotes) {
        this.totalVotes = totalVotes;
    }

    public SessionResultVotingResponse(Long idSession, Long voteYes, Long voteNo, Long totalVotes) {
        this.idSession = idSession;
        this.voteYes = voteYes;
        this.voteNo = voteNo;
        this.totalVotes = totalVotes;
    }

    @Override
    public String toString() {
        return "SessionResultVotingResponse{" +
                "idSession=" + idSession +
                ", voteYes=" + voteYes +
                ", voteNo=" + voteNo +
                ", totalVotes=" + totalVotes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionResultVotingResponse that = (SessionResultVotingResponse) o;
        return Objects.equals(idSession, that.idSession) && Objects.equals(voteYes, that.voteYes) && Objects.equals(voteNo, that.voteNo) && Objects.equals(totalVotes, that.totalVotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSession, voteYes, voteNo, totalVotes);
    }
}
