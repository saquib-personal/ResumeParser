package com.example.resumeparser.controllers;

public class ErrorResponse {

    private final Integer status;
    private final String exception;
    private final String message;


    public ErrorResponse(Integer status, String exception, String message) {
        this.status = status;
        this.exception = exception;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }
}
