package com.example.planservice.domain.port;

import com.example.planservice.domain.model.Category;

import java.util.List;

public interface CategoryPersistencePort {
    List<Category> createAll(List<Category> category);

    Category getById(Long id);

    Category update(Category category);
    List<Category> getAll();

    void deleteById(Long id);
}
