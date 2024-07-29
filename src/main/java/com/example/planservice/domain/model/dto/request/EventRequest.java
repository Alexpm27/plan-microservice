package com.example.planservice.domain.model.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class EventRequest {
    private String title;

    private String description;

    private LocalDateTime date;

    private double latitude;

    private double longitude;

    private String imageUrl;

    private String address;
}
