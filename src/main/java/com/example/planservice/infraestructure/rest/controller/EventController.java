package com.example.planservice.infraestructure.rest.controller;

import com.example.planservice.application.usercases.EventService;
import com.example.planservice.domain.model.dto.request.EventRequest;
import com.example.planservice.domain.model.dto.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {
    @Autowired
    private EventService service;

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody EventRequest request, @RequestParam List<Long> categoriesId){
        return new ResponseEntity<>(service.create(request, categoriesId), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getByCategories(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/ByCategories")
    public ResponseEntity<BaseResponse> getByCategories(@RequestParam List<String> names){
        return new ResponseEntity<>(service.getByCategories(names), HttpStatus.OK);
    }
}
