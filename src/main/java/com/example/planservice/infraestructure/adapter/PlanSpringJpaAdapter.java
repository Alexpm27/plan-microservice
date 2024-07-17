package com.example.planservice.infraestructure.adapter;

import com.example.planservice.domain.model.Plan;
import com.example.planservice.domain.port.PlanPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanSpringJpaAdapter implements PlanPersistencePort {
    @Override
    public Plan create(Plan plan, Long eventId) {
        return null;
    }

    @Override
    public Plan getById(Long id) {
        return null;
    }

    @Override
    public List<Plan> getAllByMatchId(Long id) {
        return null;
    }

    @Override
    public Plan update(Plan plan) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
