package com.example.planservice.domain.model.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class PlanRequest {
    private String title;

    private LocalDateTime dateTime;
    
    private Long matchId;

    private List<PlanRequest> places;

    private Long eventId;
}
