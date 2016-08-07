package com.sameperson.composition;

import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Composition, Long> {
}
