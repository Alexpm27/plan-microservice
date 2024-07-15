package com.example.planservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event {
    private Long id;

    private String title;

    private String description;

    private LocalDateTime date;

    private boolean isComplete;

    private double latitude;

    private double longitude;

    private String address;

    private List<Category> categories;

    private List<Plan> plans;

}
