package com.br.vanessa.vote.controller.request;

import io.swagger.annotations.ApiModelProperty;

public class SessionRequest {

    @ApiModelProperty(example = "Id da pauta")
    private Long idGuideline;
    @ApiModelProperty(example = "Tempo de duração da pauta em minutos")
    private Integer timeDuration;

    public SessionRequest(Long idGuideline, Integer timeDuration) {
        this.idGuideline = idGuideline;
        this.timeDuration = timeDuration;
    }

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
