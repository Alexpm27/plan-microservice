package com.example.planservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Place {
    private Long id;

    private String name;

    private double latitude;

    private double longitude;

    private String address;

    private Plan plan;
}
