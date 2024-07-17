package com.example.planservice.infraestructure.adapter.persistence.entity;

import com.example.planservice.domain.model.Event;
import com.example.planservice.infraestructure.adapter.mapper.ListToStringConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Convert(converter = ListToStringConverter.class)
    private List<String> activities;

    private String imageUrl;

    @ManyToMany(mappedBy = "categories")
    private List<EventEntity> events = new ArrayList<>();
}
