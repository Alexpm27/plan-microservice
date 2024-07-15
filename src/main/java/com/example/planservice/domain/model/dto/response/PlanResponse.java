package com.example.planservice.domain.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class PlanResponse {
    private Long id;

    private Long matchId;

    private String title;

    private LocalDateTime dateTime;

    private boolean isComplete;

    private List<PlaceResponse> places;

    private EventResponse event;
}
