package com.example.planservice.domain.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class EventResponse {
    private Long id;

    private String title;

    private String description;

    private LocalDateTime date;

    private boolean isComplete;

    private double latitude;

    private double longitude;

    private String address;

    private List<String> categories;
}
