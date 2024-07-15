package com.example.planservice.domain.model.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlaceRequest {
    private String name;

    private double latitude;

    private double longitude;

    private String address;
}
