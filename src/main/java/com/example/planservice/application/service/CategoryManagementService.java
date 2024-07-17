package com.example.planservice.application.service;

import com.example.planservice.application.mapper.CategoryMapper;
import com.example.planservice.application.usercases.CategoryService;
import com.example.planservice.domain.model.dto.request.CategoriesRequest;
import com.example.planservice.domain.model.dto.request.CategoryRequest;
import com.example.planservice.domain.model.dto.response.BaseResponse;
import com.example.planservice.domain.port.CategoryPersistencePort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CategoryManagementService implements CategoryService {

    private final CategoryPersistencePort port;
    private final CategoryMapper categoryMapper;

    public CategoryManagementService(final CategoryPersistencePort port,
                                     final CategoryMapper categoryMapper) {
        this.port = port;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public BaseResponse createAll(CategoriesRequest request) {
        var categoryRequest = request.getCategories()
                .stream()
                .map(categoryMapper::toDomain)
                .collect(Collectors.toList());
        var categoriesCreated = port.createAll(categoryRequest);
        return BaseResponse.builder()
                .data(categoryMapper.toDtoList(categoriesCreated))
                .message("Categories created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(201)
                .build();
    }

    @Override
    public BaseResponse getById(Long id) {
        return null;
    }

    @Override
    public BaseResponse update(CategoryRequest category) {
        return null;
    }

    @Override
    public BaseResponse getAll() {
        var categories = port.getAll();
        return BaseResponse.builder()
                .data(categoryMapper.toDtoList(categories))
                .message("Categories created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(201)
                .build();
    }

    @Override
    public void deleteById(Long id) {

    }
}
