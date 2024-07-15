package com.example.planservice.application.usercases;

import com.example.planservice.domain.model.dto.request.PlanRequest;
import com.example.planservice.domain.model.dto.response.BaseResponse;

import java.util.List;

public interface PlaceService {
    BaseResponse create(PlanRequest place);

    BaseResponse getById(Long id);

    BaseResponse getAllByPlanId(Long planId);

    void deleteById(Long id);
}
