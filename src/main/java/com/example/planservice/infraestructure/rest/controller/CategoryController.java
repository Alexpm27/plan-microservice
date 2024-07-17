package com.example.planservice.infraestructure.rest.controller;

import com.example.planservice.application.usercases.CategoryService;
import com.example.planservice.domain.model.dto.request.CategoriesRequest;
import com.example.planservice.domain.model.dto.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<BaseResponse> createAll(@RequestBody CategoriesRequest request){
        return new ResponseEntity<>(service.createAll(request), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
