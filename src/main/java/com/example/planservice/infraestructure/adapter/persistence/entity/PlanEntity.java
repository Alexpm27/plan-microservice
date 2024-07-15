package com.example.planservice.infraestructure.adapter.persistence.entity;

import com.example.planservice.domain.model.Event;
import com.example.planservice.domain.model.Place;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planes")
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private LocalDateTime dateTime;

    private Boolean isComplete;

    private Long matchId;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<PlaceEntity> places;

    @ManyToOne
    private EventEntity event;
}
