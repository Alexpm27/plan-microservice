package com.example.planservice.infraestructure.adapter.persistence.repository;

import com.example.planservice.infraestructure.adapter.persistence.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
}
