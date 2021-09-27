package com.br.vanessa.vote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponse {

    private final Integer status;
    private final String error;
    private final String message;
    private final String path;

    private ErrorResponse(String path, String message, HttpStatus httpStatus) {
        this(path, message, httpStatus.value(), httpStatus.getReasonPhrase());
    }

    private ErrorResponse(String path, String message, Integer status, String error) {
        this.path = path;
        this.message = message;
        this.status = status;
        this.error = error;
    }

    public static ErrorResponse of(String path, String message, HttpStatus httpStatus) {
        return new ErrorResponse(path, message, httpStatus);
    }

    public ResponseEntity<ErrorResponse> toResponseEntity() {
        return ResponseEntity.status(status).body(this);
    }

}
