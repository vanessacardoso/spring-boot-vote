package com.br.vanessa.vote.controller.response;

import com.br.vanessa.vote.model.Session;

import java.time.LocalDateTime;

public class SessionResponse {

    private Long idSession;
    private Long idGuideline;
    private LocalDateTime startSession;
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
