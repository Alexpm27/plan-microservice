package com.example.planservice.application.service;

import com.example.planservice.application.mapper.EventMapper;
import com.example.planservice.application.usercases.EventService;
import com.example.planservice.domain.model.dto.request.EventRequest;
import com.example.planservice.domain.model.dto.response.BaseResponse;
import com.example.planservice.domain.port.EventPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class EventManagementService implements EventService {

    private final EventPersistencePort port;

    private final EventMapper eventMapper;

    @Autowired
    public EventManagementService(final EventPersistencePort port,
                                  final EventMapper eventMapper) {
        this.port = port;
        this.eventMapper = eventMapper;
    }


    @Override
    public BaseResponse create(EventRequest event, List<Long> categoriesId) {
        var eventRequest = eventMapper.toDomain(event);
        eventRequest.setComplete(Boolean.FALSE);
        var eventCreated = port.create(eventRequest, categoriesId);
        return BaseResponse.builder()
                .data(eventMapper.toDto(eventCreated))
                .message("Event Created Successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(200)
                .build();
    }

    @Override
    public BaseResponse getById(Long id) {
        var event = port.getById(id);
        return BaseResponse.builder()
                .data(eventMapper.toDto(event))
                .message("Get Event Successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .statusCode(200)
                .build();
    }

    @Override
    public BaseResponse getByCategories(List<Long> categoriesId) {
        var eventsList = port.getByCategories(categoriesId);
        return BaseResponse.builder()
                .data(eventMapper.toDtoList(eventsList))
                .message("Get Event List Successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .statusCode(200)
                .build();
    }

    @Override
    public BaseResponse update(EventRequest event) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}

