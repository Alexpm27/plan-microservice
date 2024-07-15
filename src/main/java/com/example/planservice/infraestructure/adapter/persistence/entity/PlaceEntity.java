package com.example.planservice.infraestructure.adapter.persistence.entity;

import com.example.planservice.domain.model.Plan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "places")
public class PlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double latitude;

    private double longitude;

    private String address;

    @ManyToOne
    private PlanEntity plan;
}
