package com.example.planservice.infraestructure.adapter.persistence.repository;

import com.example.planservice.infraestructure.adapter.persistence.entity.CategoryEntity;
import com.example.planservice.infraestructure.adapter.persistence.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    List<EventEntity> findByCategoriesIn(List<CategoryEntity> categoryEntityList);
}
