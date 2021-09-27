package com.br.vanessa.vote.controller.response;

import com.br.vanessa.vote.model.Session;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class SessionResponse {

    @ApiModelProperty(example = "Identificador único da sessão")
    private Long idSession;
    @ApiModelProperty(example = "Identificador único da pauta")
    private Long idGuideline;
    @ApiModelProperty(example = "2021-09-25T23:19:19.4050134")
    private LocalDateTime startSession;
    @ApiModelProperty(example = "2021-09-25T23:20:19.4050134")
    private LocalDateTime endSession;

    public SessionResponse(Session session) {
        this.idSession = session.getId();
        this.idGuideline = session.getIdGuideline().getId();
        this.startSession = session.getStartSession();
        this.endSession = session.getEndSession();
    }

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }

    public Long getIdGuideline() {
        return idGuideline;
    }

    public void setIdGuideline(Long idGuideline) {
        this.idGuideline = idGuideline;
    }

    public LocalDateTime getStartSession() {
        return startSession;
    }

    public void setStartSession(LocalDateTime startSession) {
        this.startSession = startSession;
    }

    public LocalDateTime getEndSession() {
        return endSession;
    }

    public void setEndSession(LocalDateTime endSession) {
        this.endSession = endSession;
    }
}
