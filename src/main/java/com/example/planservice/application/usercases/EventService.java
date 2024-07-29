package com.example.planservice.application.usercases;

import com.example.planservice.domain.model.dto.request.EventRequest;
import com.example.planservice.domain.model.dto.response.BaseResponse;

import java.util.List;

public interface EventService {
    BaseResponse create(EventRequest event, List<Long> categoriesId);

    BaseResponse getById(Long id);

    BaseResponse getByCategories(List<String> names);

    BaseResponse update(EventRequest event);

    void deleteById(Long id);
}
