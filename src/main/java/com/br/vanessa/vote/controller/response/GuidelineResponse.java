package com.br.vanessa.vote.controller.response;

import com.br.vanessa.vote.model.Guideline;

public class GuidelineResponse {

    private Long id;
    private String title;
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
