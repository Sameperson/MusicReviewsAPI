package com.sameperson.composition;

import com.sameperson.core.BaseEntity;
import com.sameperson.review.Review;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Composition extends BaseEntity {
    private String title;
    private String url;
    @OneToMany(mappedBy = "composition", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Composition() {
        super();
        reviews = new ArrayList<>();
    }

    public Composition(String title, String url) {
        this();
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
}
