package com.ceiba.biblioteca.general_configuration.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;
	private String code;
    private HttpStatus status;

    public RequestException(String code, HttpStatus status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
