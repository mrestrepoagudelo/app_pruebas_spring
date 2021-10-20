package com.coop.application.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.coop.domain.exception.InternalErrorException;
import com.coop.domain.exception.ModelException;

@ControllerAdvice
public class ExceptionConfig {
	
	@ExceptionHandler(ModelException.class)
	public ResponseEntity<Object> modelException(ModelException e){
		ErrorMessage errorMessage = new ErrorMessage(
			e.getMessage(), 
			HttpStatus.BAD_REQUEST, 
			ZonedDateTime.now(ZoneId.of("America/Bogota"))
		);
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InternalErrorException.class)
	public ResponseEntity<?> internalErrorException(InternalErrorException e){
		String msgError = "Error Internal Exception: ";
		ErrorMessage errorMessage = new ErrorMessage(
			msgError + e.getMessage(), 
			HttpStatus.BAD_REQUEST, 
			ZonedDateTime.now(ZoneId.of("America/Bogota"))
		);
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
	}
}
