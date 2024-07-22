package com.example.planservice.application.mapper;

import com.example.planservice.domain.model.Place;
import com.example.planservice.domain.model.Plan;
import com.example.planservice.domain.model.dto.request.PlanRequest;
import com.example.planservice.domain.model.dto.response.EventResponse;
import com.example.planservice.domain.model.dto.response.PlaceResponse;
import com.example.planservice.domain.model.dto.response.PlanResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanMapper {
    private final PlaceMapper placeMapper;

    private final EventMapper eventMapper;

    public PlanMapper(final PlaceMapper mapper, EventMapper eventMapper) {
        this.placeMapper = mapper;
        this.eventMapper = eventMapper;
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
        List<PlaceResponse> placeResponses = plan.getPlaces() != null ?
                plan.getPlaces().stream()
                        .map(placeMapper::toDto)
                        .collect(Collectors.toList()) :
                Collections.emptyList();

        EventResponse eventResponse = plan.getEvent() != null ?
                eventMapper.toDto(plan.getEvent()) :
                null;

        return PlanResponse.builder()
                .id(plan.getId())
                .title(plan.getTitle())
                .matchId(plan.getMatchId())
                .dateTime(plan.getDateTime())
                .isComplete(plan.getIsComplete())
                .places(placeResponses)
                .event(eventResponse)
                .build();
    }
}
