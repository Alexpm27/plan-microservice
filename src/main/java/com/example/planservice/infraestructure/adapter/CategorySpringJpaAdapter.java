package com.example.planservice.infraestructure.adapter;

import com.example.planservice.domain.model.Category;
import com.example.planservice.domain.port.CategoryPersistencePort;
import com.example.planservice.infraestructure.adapter.mapper.CategoryDboMapper;
import com.example.planservice.infraestructure.adapter.persistence.entity.CategoryEntity;
import com.example.planservice.infraestructure.adapter.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySpringJpaAdapter implements CategoryPersistencePort {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryDboMapper dboMapper;
    @Override
    public List<Category> createAll(List<Category> category) {
        List<CategoryEntity> entities = dboMapper.toEntityList(category);
        List<CategoryEntity> entitySaved = repository.saveAll(entities);
        return dboMapper.toDomainList(entitySaved);
    }

    @Override
    public Category getById(Long id) {
        return null;
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return dboMapper.toDomainList(repository.findAll());
    }

    @Override
    public void deleteById(Long id) {

    }
}
