package com.example.planservice.application.usercases;

import com.example.planservice.domain.model.dto.request.CategoriesRequest;
import com.example.planservice.domain.model.dto.request.CategoryRequest;
import com.example.planservice.domain.model.dto.response.BaseResponse;

public interface CategoryService {
    BaseResponse createAll(CategoriesRequest category);

    BaseResponse getById(Long id);

    BaseResponse update(CategoryRequest category);

    BaseResponse getAll();

    void deleteById(Long id);
}
