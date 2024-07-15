package com.example.planservice.domain.port;

import com.example.planservice.domain.model.Place;

import java.util.List;

public interface PlacePersistencePort {
    Place create(Place place);

    Place getById(Long id);

    List<Place> getAllByPlanId(Long planId);

    void deleteById(Long id);
}
