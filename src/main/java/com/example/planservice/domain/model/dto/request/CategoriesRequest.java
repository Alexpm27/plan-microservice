package com.example.planservice.domain.model.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class CategoriesRequest {
    private List<CategoryRequest> categories;
}
