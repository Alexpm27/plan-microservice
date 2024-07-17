package com.example.planservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    private Long id;

    private String name;

    private List<String> activities;

    private String imageUrl;

    private List<Event> events;
}
