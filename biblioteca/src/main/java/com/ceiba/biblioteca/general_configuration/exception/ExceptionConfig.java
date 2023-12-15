package com.ceiba.biblioteca.general_configuration.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorMessage> runtimeException(RuntimeException e) {
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("America/Bogota")));
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RequestException.class)
	public ResponseEntity<ErrorMessage> requestException(RequestException e) {
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("America/Bogota")));
		return new ResponseEntity<>(errorMessage, e.getStatus());
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorMessage> businessException(BusinessException e) {
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("America/Bogota")));
		return new ResponseEntity<>(errorMessage, e.getStatus());
	}
}