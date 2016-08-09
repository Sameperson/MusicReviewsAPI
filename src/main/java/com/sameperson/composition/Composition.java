package com.sameperson.composition;

import com.sameperson.core.BaseEntity;
import com.sameperson.review.Review;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Composition extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 30)
    private String author;
    @Size(min = 3, max = 140)
    private String title;
    private String url;
    @OneToMany(mappedBy = "composition", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Composition() {
        super();
        reviews = new ArrayList<>();
    }

    public Composition(String author, String title, String url) {
        this();
        this.author = author;
        this.title = title;
        this.url = url;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        review.setComposition(this);
        reviews.add(review);
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
