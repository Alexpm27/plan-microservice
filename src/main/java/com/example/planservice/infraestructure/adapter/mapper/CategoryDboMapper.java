package com.example.planservice.infraestructure.adapter.mapper;

import com.example.planservice.domain.model.Category;
import com.example.planservice.infraestructure.adapter.persistence.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDboMapper {
    public Category toDomain(CategoryEntity entity){
        Category category = new Category();
        category.setId(entity.getId());
        category.setName(entity.getName());
        category.setImageUrl(entity.getImageUrl());
        category.setActivities(entity.getActivities());
        return category;
    }

    public CategoryEntity toEntity(Category category){
        CategoryEntity entity = new CategoryEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        entity.setImageUrl(category.getImageUrl());
        entity.setActivities(category.getActivities());
        return entity;
    }

    public List<CategoryEntity> toEntityList(List<Category> categories){
        return categories.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public List<Category> toDomainList(List<CategoryEntity> categoryEntities){
        return categoryEntities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
