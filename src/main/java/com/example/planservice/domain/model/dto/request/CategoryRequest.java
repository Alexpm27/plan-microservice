package com.example.planservice.domain.model.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class CategoryRequest {
    private String name;

    private List<String> activities;

    private String imageUrl;
}
