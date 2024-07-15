package com.example.planservice.infraestructure.adapter.mapper;

import com.example.planservice.domain.model.Category;
import com.example.planservice.infraestructure.adapter.persistence.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryDboMapper {
    public Category toDomain(CategoryEntity entity){
        Category category = new Category();
        category.setId(entity.getId());
        category.setName(entity.getName());
        return category;
    }

    public CategoryEntity toEntity(Category category){
        CategoryEntity entity = new CategoryEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        return entity;
    }
}
