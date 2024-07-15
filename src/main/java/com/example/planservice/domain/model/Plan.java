package com.example.planservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plan {
    private Long id;

    private String title;

    private LocalDateTime dateTime;

    private Boolean isComplete;

    private Long matchId;

    private List<Place> places;

    private Event event;
}
