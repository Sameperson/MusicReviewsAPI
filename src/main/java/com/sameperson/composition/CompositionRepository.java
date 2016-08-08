package com.sameperson.composition;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface CompositionRepository extends PagingAndSortingRepository<Composition, Long> {

    @RestResource(path = "containsTitle", rel = "title-contains")
    Page<Composition> findByTitleContaining(@Param("title") String title, Pageable page);

}
