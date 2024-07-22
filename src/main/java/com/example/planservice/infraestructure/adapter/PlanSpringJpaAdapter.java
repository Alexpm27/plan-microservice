package com.example.planservice.infraestructure.adapter;

import com.example.planservice.application.mapper.PlanMapper;
import com.example.planservice.domain.model.Plan;
import com.example.planservice.domain.port.EventPersistencePort;
import com.example.planservice.domain.port.PlanPersistencePort;
import com.example.planservice.infraestructure.adapter.mapper.PlanDboMapper;
import com.example.planservice.infraestructure.adapter.persistence.entity.EventEntity;
import com.example.planservice.infraestructure.adapter.persistence.entity.PlaceEntity;
import com.example.planservice.infraestructure.adapter.persistence.entity.PlanEntity;
import com.example.planservice.infraestructure.adapter.persistence.exception.DestinationNotEntered;
import com.example.planservice.infraestructure.adapter.persistence.exception.NotFoundException;
import com.example.planservice.infraestructure.adapter.persistence.repository.PlaceRepository;
import com.example.planservice.infraestructure.adapter.persistence.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanSpringJpaAdapter implements PlanPersistencePort {
    @Autowired
    private PlanRepository repository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PlanDboMapper dboMapper;

    @Autowired
    private EventPersistencePort eventPersistencePort;
    @Override
    public Plan create(Plan plan, Long eventId) {
        PlanEntity entity = dboMapper.toEntity(plan);


        if (eventId != null){
            EventEntity event = eventPersistencePort.findAndEnsureExist(eventId);
            entity.setEvent(event);
        } else if (plan.getPlaces() == null || plan.getPlaces().isEmpty()) {
            throw new DestinationNotEntered();
        }
        PlanEntity planSaved = repository.save(entity);
        savePlaces(planSaved.getPlaces(), planSaved);

        return dboMapper.toDomain(planSaved);
    }

    @Override
    public Plan getById(Long id) {
        return dboMapper.toDomain(findAndEnsureExist(id));
    }

    @Override
    public List<Plan> getAllByMatchId(Long id) {
        List<PlanEntity> entities = repository.findAllByMatchId(id);
        return entities.stream()
                .map(dboMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Plan update(Plan plan) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private PlanEntity findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    private List<PlaceEntity> savePlaces(List<PlaceEntity> placeEntities, PlanEntity plan){
        List<PlaceEntity> request = placeEntities.stream()
                .map(x -> {
                    x.setPlan(plan);
                    return x;
                })
                .collect(Collectors.toList());
        return placeRepository.saveAll(request);
    }
}
