package com.example.planservice.infraestructure.adapter.persistence.repository;

import com.example.planservice.infraestructure.adapter.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Query("SELECT c FROM CategoryEntity c WHERE c.name IN :names")
    List<CategoryEntity> findAllByNameIn(@Param("names") List<String> names);
}
