package com.example.planservice.domain.port;

import com.example.planservice.domain.model.Event;

import java.util.List;

public interface EventPersistencePort {
    Event create(Event event, List<Long> categoriesId);

    Event getById(Long id);

    List<Event> getByCategories(List<Long> categoriesId);

    Event update(Event event);

    void deleteById(Long id);

}
