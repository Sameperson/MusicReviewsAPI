package com.sameperson.core;

import com.sameperson.composition.Composition;
import com.sameperson.composition.CompositionRepository;
import com.sameperson.review.Review;
import com.sameperson.user.User;
import com.sameperson.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final CompositionRepository compositions;
    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(CompositionRepository compositions, UserRepository userRepository) {
        this.compositions = compositions;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Composition composition = new Composition("TheFatRat", "Monody (feat. Laura Brehm)", "https://www.youtube.com/watch?v=nw5Mc5bpq-A");
        composition.addReview(new Review(5, "Great track, nice production and mixing!"));
        compositions.save(composition);

        String[] authors = {
                "TheFatRat",
                "Studio Killers",
                "Caravan Palace",
                "Carpenter Brut",
                "K flay",
                "Nowtro"
        };
        String[] titleTemplates = {
                "TheFatRat - Song about %s",
                "Studio Killers - %s song",
                "Caravan Palace - Rise of the %s",
                "Carpenter Brut - Dance of %s"
        };
        String[] words = {
                "Robots",
                "Mad people",
                "DJ",
                "AI",
                "Aliens"
        };
        List<User> users = Arrays.asList(
                new User("sameperson", "Dmitry", "Ponomarenko", "password", new String[]{"ROLE_USER"}),
                new User("java8pro", "John", "Smith", "password", new String[]{"ROLE_USER"}),
                new User("aragorn", "Viggo", "Mortensen", "password", new String[]{"ROLE_USER"}),
                new User("purple_smart", "Twilight", "Sparkle", "password", new String[]{"ROLE_USER"}),
                new User("gunslinger", "Roland", "Deschain", "password", new String[]{"ROLE_USER"})
        );
        userRepository.save(users);
        userRepository.save(new User("admin", "admin", "admin", "admin", new String[]{"ROLE_USER", "ROLE_ADMIN"}));
        List<Composition> collectionOfCompositions = new ArrayList<>();
        IntStream.range(0, 100).forEach(i -> {
            String author = authors[i % authors.length];
            String titleTemplate = titleTemplates[i % titleTemplates.length];
            String word = words[i % words.length];
            String title = String.format(titleTemplate, word);
            Composition c = new Composition(author, title, "https://www.google.com.ua/");
            Review review = new Review((i % 5) + 1, title + " is rad stuff!");
            review.setReviewer(users.get(i % users.size()));
            c.addReview(review);
            collectionOfCompositions.add(c);
        });
        compositions.save(collectionOfCompositions);

    }
}
