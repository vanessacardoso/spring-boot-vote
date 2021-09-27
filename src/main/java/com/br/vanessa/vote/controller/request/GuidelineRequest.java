package com.br.vanessa.vote.controller.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class GuidelineRequest {

    @ApiModelProperty(example = "Nome da pauta")
    @NotBlank
    private String title;
    @ApiModelProperty(example = "Descrição da pauta")
    private String description;

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
