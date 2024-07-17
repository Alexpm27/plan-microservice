package com.example.planservice.application.mapper;

import com.example.planservice.domain.model.Place;
import com.example.planservice.domain.model.dto.request.PlaceRequest;
import com.example.planservice.domain.model.dto.response.PlaceResponse;
import org.springframework.stereotype.Component;

@Component
public class PlaceMapper {
    public Place toDomain(PlaceRequest request){
        Place place = new Place();
        place.setName(request.getName());
        place.setAddress(request.getAddress());
        place.setLatitude(request.getLatitude());
        place.setLongitude(request.getLongitude());
        return place;
    }

    public PlaceResponse toDto(Place place){
        return PlaceResponse.builder()
                .id(place.getId())
                .name(place.getName())
                .address(place.getAddress())
                .latitude(place.getLatitude())
                .longitude(place.getLongitude())
                .build();
    }
}
