package com.br.vanessa.vote.controller.request;

public class SessionRequest {

    private Long idGuideline;
    private Integer timeDuration;

    public Long getIdGuideline() {
        return idGuideline;
    }

    public void setIdGuideline(Long idGuideline) {
        this.idGuideline = idGuideline;
    }

    public Integer getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(Integer timeDuration) {
        this.timeDuration = timeDuration;
    }
}
