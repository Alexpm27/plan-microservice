package com.example.planservice.infraestructure.adapter.persistence.exception;

public class DestinationNotEntered extends RuntimeException{
    public DestinationNotEntered() {
        super("Both eventId and places cannot be null");
    }
}
