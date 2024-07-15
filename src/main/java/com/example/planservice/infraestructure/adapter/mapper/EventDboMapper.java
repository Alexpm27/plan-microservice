package com.example.planservice.infraestructure.adapter.mapper;

import com.example.planservice.domain.model.Category;
import com.example.planservice.domain.model.Event;
import com.example.planservice.infraestructure.adapter.persistence.entity.CategoryEntity;
import com.example.planservice.infraestructure.adapter.persistence.entity.EventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventDboMapper {
    @Autowired
    private CategoryDboMapper categoryDboMapper;
    public Event toDomain(EventEntity entity){
        Event event = new Event();
        List<Category> categories = entity.getCategories()
                .stream()
                .map(categoryDboMapper::toDomain)
                .collect(Collectors.toList());
        event.setId(entity.getId());
        event.setTitle(entity.getTitle());
        event.setDescription(entity.getDescription());
        event.setDate(entity.getDate());
        event.setComplete(entity.isComplete());
        event.setLatitude(entity.getLatitude());
        event.setLongitude(entity.getLongitude());
        event.setAddress(entity.getAddress());
        event.setCategories(categories);
        return event;
    }

    public EventEntity toEntity(Event event){
        EventEntity entity = new EventEntity();
        entity.setId(event.getId());
        entity.setTitle(event.getTitle());
        entity.setDescription(event.getDescription());
        entity.setDate(event.getDate());
        entity.setComplete(event.isComplete());
        entity.setLatitude(event.getLatitude());
        entity.setLongitude(event.getLongitude());
        entity.setAddress(event.getAddress());
        return entity;
    }
}
