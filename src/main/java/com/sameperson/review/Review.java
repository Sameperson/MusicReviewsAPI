package com.sameperson.review;

import com.sameperson.composition.Composition;
import com.sameperson.core.BaseEntity;
import com.sameperson.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Review extends BaseEntity {
    private int rating;
    @NotNull
    @Size(min = 10, max = 600)
    private String description;
    @ManyToOne
    private Composition composition;
    @ManyToOne
    private User reviewer;

    protected Review() {
        super();
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }
}
