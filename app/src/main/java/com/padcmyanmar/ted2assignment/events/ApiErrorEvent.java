package com.padcmyanmar.ted2assignment.events;

public class ApiErrorEvent {

    private String errorMessage;

    public ApiErrorEvent(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
