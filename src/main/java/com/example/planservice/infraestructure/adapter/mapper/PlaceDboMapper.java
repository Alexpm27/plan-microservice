package com.example.planservice.infraestructure.adapter.mapper;

import com.example.planservice.domain.model.Place;
import com.example.planservice.infraestructure.adapter.persistence.entity.PlaceEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaceDboMapper {
    public PlaceEntity toEntity(Place domain){
        PlaceEntity entity = new PlaceEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setAddress(domain.getAddress());
        entity.setLongitude(domain.getLongitude());
        entity.setLatitude(domain.getLatitude());
        return entity;
    }

    public Place toDomain(PlaceEntity entity){
        Place domain = new Place();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setAddress(entity.getAddress());
        domain.setLongitude(entity.getLongitude());
        domain.setLatitude(entity.getLatitude());
        return domain;
    }

    public List<PlaceEntity> toEntityList(List<Place> places){
        return places.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public List<Place> toDomainList(List<PlaceEntity> entities){
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
