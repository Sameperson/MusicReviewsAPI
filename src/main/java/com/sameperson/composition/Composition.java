package com.sameperson.composition;

import com.sameperson.core.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Composition extends BaseEntity {
    private String title;
    private String url;

    protected Composition() {
        super();
    }

    public Composition(String title, String url) {
        this();
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
