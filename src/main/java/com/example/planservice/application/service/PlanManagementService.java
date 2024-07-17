package com.example.planservice.application.service;

import com.example.planservice.application.mapper.PlanMapper;
import com.example.planservice.application.usercases.PlanService;
import com.example.planservice.domain.model.dto.request.PlanRequest;
import com.example.planservice.domain.model.dto.response.BaseResponse;
import com.example.planservice.domain.port.PlanPersistencePort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PlanManagementService implements PlanService {
    private final PlanPersistencePort port;

    private final PlanMapper planMapper;
    public PlanManagementService(final PlanPersistencePort port,
                                 final PlanMapper planMapper) {
        this.port = port;
        this.planMapper = planMapper;
    }

    @Override
    public BaseResponse create(PlanRequest plan, Long eventId) {
        var planRequest = planMapper.toDomain(plan);
        var planCreated = port.create(planRequest,eventId);
        return BaseResponse.builder()
                .data(planMapper.toDto(planCreated))
                .message("Plan created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(201)
                .build();
    }

    @Override
    public BaseResponse getById(Long id) {
        return BaseResponse.builder()
                .data(planMapper.toDto(port.getById(id)))
                .message("Get Plan successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .statusCode(201)
                .build();
    }

    @Override
    public BaseResponse getAllByMatchId(Long id) {
        var planList = port.getAllByMatchId(id);
        var planResponse = planList.stream()
                .map(planMapper::toDto)
                .collect(Collectors.toList());
        return BaseResponse.builder()
                .data(planResponse)
                .message("Get All By Match Id Plan successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .statusCode(201)
                .build();
    }

    @Override
    public BaseResponse update(PlanRequest plan) {
        var planRequest = planMapper.toDomain(plan);
        var planUpdated = port.update(planRequest);
        return BaseResponse.builder()
                .data(planMapper.toDto(planUpdated))
                .message("Plan created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(201)
                .build();
    }

    @Override
    public void deleteById(Long id) {
        port.deleteById(id);
    }
}
