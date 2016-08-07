package com.sameperson.core;

import com.sameperson.composition.Composition;
import com.sameperson.composition.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
        compositions.save(composition);

    }
}
