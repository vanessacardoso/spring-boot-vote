package com.br.vanessa.vote.model;

import com.br.vanessa.vote.controller.request.VoteRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long idSession;

    @Column
    private String cpf;

    @Column
    private VoteEnum vote;

    public Vote(VoteRequest request) {
        this.idSession = request.getIdSession();
        this.cpf = request.getCpf();
        this.vote = request.getVote();
    }

    //Should for test unit
    public Vote(Long id, Long idSession, String cpf, VoteEnum vote) {
        this.id = id;
        this.idSession = idSession;
        this.cpf = cpf;
        this.vote = vote;
    }
    //Should for test unit
    public Vote(Long idSession, String cpf, VoteEnum vote) {
        this.idSession = idSession;
        this.cpf = cpf;
        this.vote = vote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
