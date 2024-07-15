package com.example.planservice.domain.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder @Setter @Getter
public class BaseResponse {
    private Object data;

    private String message;

    private Boolean success;

    private Integer statusCode;

    private HttpStatus httpStatus;
}
