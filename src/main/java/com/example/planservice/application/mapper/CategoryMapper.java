package com.example.planservice.application.mapper;

import com.example.planservice.domain.model.Category;
import com.example.planservice.domain.model.dto.request.CategoryRequest;
import com.example.planservice.domain.model.dto.response.CategoryResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public Category toDomain(CategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());
        category.setActivities(request.getActivities());
        category.setImageUrl(request.getImageUrl());
        return category;
    }

    public CategoryResponse toDto(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .activities(category.getActivities())
                .imageUrl(category.getImageUrl())
                .build();
    }

    public List<CategoryResponse> toDtoList(List<Category> categories){
        return categories
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
