package com.simbirsoft.springcourse.service.MistakesController;

public class ThereIsNoSuchUserException extends RuntimeException {
    public ThereIsNoSuchUserException(String message) {
        super(message);
    }
}
