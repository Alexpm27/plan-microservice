package com.example.planservice.infraestructure.adapter;

import com.example.planservice.domain.model.Event;
import com.example.planservice.infraestructure.adapter.persistence.exception.InvalidEventTimeException;
import com.example.planservice.domain.port.EventPersistencePort;
import com.example.planservice.infraestructure.adapter.mapper.EventDboMapper;
import com.example.planservice.infraestructure.adapter.persistence.entity.CategoryEntity;
import com.example.planservice.infraestructure.adapter.persistence.entity.EventEntity;
import com.example.planservice.infraestructure.adapter.persistence.exception.NotFoundException;
import com.example.planservice.infraestructure.adapter.persistence.repository.CategoryRepository;
import com.example.planservice.infraestructure.adapter.persistence.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventSpringJpaAdapter implements EventPersistencePort {
    @Autowired
    private EventRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EventDboMapper dboMapper;

    @Override
    public Event create(Event event, List<Long> categoriesId) {
        validateEventTime(event.getDate());
        EventEntity entity = dboMapper.toEntity(event);
        List<CategoryEntity> categoryEntities = categoryRepository.findAllById(categoriesId);
        entity.setCategories(categoryEntities);
        Event eventCreated = dboMapper.toDomain(repository.save(entity));
        return eventCreated;
    }

    @Override
    public Event getById(Long id) {
        return dboMapper.toDomain(findAndEnsureExist(id));
    }

    @Override
    public List<Event> getByCategories(List<Long> categoriesId) {
        List<CategoryEntity> categoryEntities = categoryRepository.findAllById(categoriesId);
        return repository.findByCategoriesIn(categoryEntities)
                .stream()
                .map(dboMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Event update(Event event) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public EventEntity findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    private void validateEventTime(LocalDateTime eventDateTime) {
        LocalDateTime now = LocalDateTime.now();
        long minutesUntilEvent = ChronoUnit.MINUTES.between(now, eventDateTime);

        if (minutesUntilEvent < 10) {
            throw new InvalidEventTimeException("Event cannot be created within 10 minutes from now.");
        }
    }
}
