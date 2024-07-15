package com.example.planservice.application.usercases;

import com.example.planservice.domain.model.dto.request.PlanRequest;
import com.example.planservice.domain.model.dto.response.BaseResponse;

import java.util.List;

public interface PlanService {
    BaseResponse create(PlanRequest plan);

    BaseResponse getById(Long id);

    BaseResponse getAllByMatchId(Long id);

    BaseResponse update(PlanRequest plan);

    void deleteById(Long id);
}
