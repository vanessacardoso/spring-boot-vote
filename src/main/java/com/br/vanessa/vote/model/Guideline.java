package com.br.vanessa.vote.model;

import com.br.vanessa.vote.controller.request.GuidelineRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guideline")
public class Guideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    public Guideline() {
    }

    public Guideline(GuidelineRequest request) {
        this.title = request.getTitle();
        this.description = request.getDescription();
    }

    //Should for test unit
    public Guideline(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    //Should for test unit
    public Guideline(String title, String description) {
        this.title = title;
        this.description = description;
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

    @Override
    public String toString() {
        return "Guideline{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
