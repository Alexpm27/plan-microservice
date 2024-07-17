package com.example.planservice.domain.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class CategoryResponse {
    private Long id;
    private String name;

    private List<String> activities;

    private String imageUrl;
}
