package com.example.planservice.application.mapper;

import com.example.planservice.domain.model.Event;
import com.example.planservice.domain.model.dto.request.EventRequest;
import com.example.planservice.domain.model.dto.response.EventResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {
    public Event toDomain(EventRequest request){
        Event event = new Event();
        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setDate(request.getDate());
        event.setComplete(Boolean.FALSE);
        event.setLatitude(request.getLatitude());
        event.setLongitude(request.getLongitude());
        event.setAddress(request.getAddress());
        return event;
    }

    public EventResponse toDto(Event event){
        var categoriesName = event.getCategories()
                .stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());
        return EventResponse.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .date(event.getDate())
                .isComplete(event.isComplete())
                .latitude(event.getLatitude())
                .longitude(event.getLongitude())
                .address(event.getAddress())
                .categories(categoriesName)
                .build();
    }

    public List<EventResponse> toDtoList(List<Event> events){
        return events.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
