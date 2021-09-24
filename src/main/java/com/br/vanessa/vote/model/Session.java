package com.br.vanessa.vote.model;

import lombok.Builder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Builder
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_guideline")
    private Guideline idGuideline;

    @Column
    private LocalDateTime startSession;

    @Column
    private LocalDateTime endSession;

    @Column
    private Integer timeSession;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guideline getIdGuideline() {
        return idGuideline;
    }

    public void setIdGuideline(Guideline idGuideline) {
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

    public Integer getTimeSession() {
        return timeSession;
    }

    public void setTimeSession(Integer timeSession) {
        this.timeSession = timeSession;
    }

    public Session(Long id, Guideline idGuideline, LocalDateTime startSession, LocalDateTime endSession, Integer timeSession) {
        this.id = id;
        this.idGuideline = idGuideline;
        this.startSession = startSession;
        this.endSession = endSession;
        this.timeSession = timeSession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) && Objects.equals(idGuideline, session.idGuideline) && Objects.equals(startSession, session.startSession) && Objects.equals(endSession, session.endSession) && Objects.equals(timeSession, session.timeSession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idGuideline, startSession, endSession, timeSession);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", idPauta=" + idGuideline +
                ", startSession=" + startSession +
                ", endSession=" + endSession +
                ", timeSession=" + timeSession +
                '}';
    }
}
