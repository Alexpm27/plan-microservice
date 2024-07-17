package com.example.planservice.domain.port;

import com.example.planservice.domain.model.Plan;

import java.util.List;

public interface PlanPersistencePort {
    Plan create(Plan plan, Long eventId);

    Plan getById(Long id);

    List<Plan> getAllByMatchId(Long id);

    Plan update(Plan plan);

    void deleteById(Long id);
}
