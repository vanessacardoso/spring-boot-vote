package com.br.vanessa.vote.controller.response;

import com.br.vanessa.vote.model.Guideline;
import io.swagger.annotations.ApiModelProperty;

public class GuidelineResponse {

    @ApiModelProperty(example = "1")
    private Long id;
    @ApiModelProperty(example = "Nome da pauta")
    private String title;
    @ApiModelProperty(example = "Descrição da pauta")
    private String description;

    public GuidelineResponse(Guideline guideline) {
        this.id = guideline.getId();
        this.title = guideline.getTitle();
        this.description = guideline.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
