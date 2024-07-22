package com.example.planservice.infraestructure.adapter.mapper;

import com.example.planservice.domain.model.Plan;
import com.example.planservice.infraestructure.adapter.persistence.entity.PlanEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class PlanDboMapper {
    private final PlaceDboMapper placeDboMapper;

    private final EventDboMapper eventDboMapper;

    public PlanDboMapper(PlaceDboMapper placeDboMapper, EventDboMapper eventDboMapper) {
        this.placeDboMapper = placeDboMapper;
        this.eventDboMapper = eventDboMapper;
    }

    public PlanEntity toEntity(Plan domain){
        PlanEntity entity = new PlanEntity();
        entity.setId(domain.getId());
        entity.setTitle(domain.getTitle());
        entity.setDateTime(domain.getDateTime());
        entity.setIsComplete(domain.getIsComplete());
        entity.setMatchId(domain.getMatchId());
        entity.setPlaces(placeDboMapper.toEntityList(domain.getPlaces()));
        return entity;
    }

    public Plan toDomain(PlanEntity entity){
        Plan domain = new Plan();
        domain.setId(entity.getId());
        domain.setTitle(entity.getTitle());
        domain.setDateTime(entity.getDateTime());
        domain.setIsComplete(entity.getIsComplete());
        domain.setMatchId(entity.getMatchId());
        if (entity.getPlaces() != null) {
            domain.setPlaces(placeDboMapper.toDomainList(entity.getPlaces()));
        } else {
            domain.setPlaces(Collections.emptyList());
        }
        if (entity.getEvent() != null) {
            domain.setEvent(eventDboMapper.toDomain(entity.getEvent()));
        } else {
            domain.setEvent(null);
        }
        return domain;
    }
}
