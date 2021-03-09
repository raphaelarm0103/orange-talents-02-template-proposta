package com.api.proposta.erroshandler;

import org.springframework.http.HttpStatus;

public class ApiErroException extends RuntimeException {

    private final HttpStatus httpStatus;

    private final String reason;

    public ApiErroException(HttpStatus httpStatus, String reason) {
        super(reason);
        this.httpStatus = httpStatus;
        this.reason = reason;

    }

    public ApiErroException(String message, HttpStatus httpStatus, String reason) {
        super(message);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public ApiErroException(String message, Throwable cause, HttpStatus httpStatus, String reason) {
        super(message, cause);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public ApiErroException(Throwable cause, HttpStatus httpStatus, String reason) {
        super(cause);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public ApiErroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus httpStatus, String reason) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getReason() {
        return reason;
    }
}