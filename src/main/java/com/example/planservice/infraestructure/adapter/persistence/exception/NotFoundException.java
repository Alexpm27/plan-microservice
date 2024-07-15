package com.example.planservice.infraestructure.adapter.persistence.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Data Not Found");
    }
}
