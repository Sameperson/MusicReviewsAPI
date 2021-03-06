package com.sameperson.review;

import com.sameperson.user.User;
import com.sameperson.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Review.class)
public class ReviewEventHandler {
    private final UserRepository userRepository;

    @Autowired
    public ReviewEventHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @HandleBeforeCreate
    public void addReviewerBasedOnLoggedInUser(Review review) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        review.setReviewer(user);

    }
}
