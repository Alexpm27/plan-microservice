package com.example.planservice.infraestructure.rest.controller;

import com.example.planservice.application.usercases.PlanService;
import com.example.planservice.domain.model.dto.request.PlanRequest;
import com.example.planservice.domain.model.dto.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("plan")
public class PlanController {
    @Autowired
    private PlanService service;

    @PostMapping({"/", "/{eventId}"})
    public ResponseEntity<BaseResponse> create(@RequestBody PlanRequest request, @PathVariable(value = "eventId", required = false) Long eventId){
        return new ResponseEntity<>(service.create(request, eventId), HttpStatus.CREATED);
    }

    @GetMapping("/{planId}")
    public ResponseEntity<BaseResponse> getById(@PathVariable Long planId){
        return new ResponseEntity<>(service.getById(planId), HttpStatus.OK);
    }

    @GetMapping("/plans/{matchId}")
    public ResponseEntity<BaseResponse> getAllByMatchId(@PathVariable Long matchId){
        return new ResponseEntity<>(service.getAllByMatchId(matchId), HttpStatus.OK);
    }

    @DeleteMapping("/{planId}")
    public void deleteById(@PathVariable Long planId){
        service.deleteById(planId);
    }
}
