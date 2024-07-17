package com.example.planservice.application.mapper;

import com.example.planservice.domain.model.Place;
import com.example.planservice.domain.model.Plan;
import com.example.planservice.domain.model.dto.request.PlanRequest;
import com.example.planservice.domain.model.dto.response.PlanResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanMapper {
    private final PlaceMapper placeMapper;

    public PlanMapper(final PlaceMapper mapper) {
        this.placeMapper = mapper;
    }

    public Plan toDomain(PlanRequest request){
        List<Place> places = request.getPlaces()
                .stream()
                .map(placeMapper::toDomain)
                .collect(Collectors.toList());

        Plan plan = new Plan();
        plan.setTitle(request.getTitle());
        plan.setDateTime(request.getDateTime());
        plan.setMatchId(request.getMatchId());
        plan.setPlaces(places);
        return plan;
    }

    public PlanResponse toDto(Plan plan){
        return PlanResponse.builder()
                .id(plan.getId())
                .title(plan.getTitle())
                .matchId(plan.getMatchId())
                .dateTime(plan.getDateTime())
                .isComplete(plan.getIsComplete())
                .build();
    }
}
