package com.example.planservice.infraestructure.adapter.persistence.exception;

public class InvalidEventTimeException extends RuntimeException{
    public InvalidEventTimeException(String message) {
        super(message);
    }
}
