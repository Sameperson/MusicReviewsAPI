package com.sameperson.core;

import com.sameperson.composition.Composition;
import com.sameperson.composition.CompositionRepository;
import com.sameperson.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final CompositionRepository compositions;

    @Autowired
    public DatabaseLoader(CompositionRepository compositions) {
        this.compositions = compositions;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Composition composition = new Composition("TheFatRat - Monody (feat. Laura Brehm)", "https://www.youtube.com/watch?v=nw5Mc5bpq-A");
        composition.addReview(new Review(5, "Great track, nice production and mixing!"));
        compositions.save(composition);

        String[] templates = {
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
        List<Composition> collectionOfCompositions = new ArrayList<>();
        IntStream.range(0, 100).forEach(i -> {
            String template = templates[i % templates.length];
            String word = words[i % words.length];
            String title = String.format(template, word);
            Composition c = new Composition(title, "https://www.google.com.ua/");
            c.addReview(new Review(i % 5, title + " is rad stuff!"));
            collectionOfCompositions.add(c);
        });
        compositions.save(collectionOfCompositions);

    }
}
