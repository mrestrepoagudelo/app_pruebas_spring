package com.ceiba.biblioteca.libro.domain.exception;

public class ModelException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public ModelException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public ModelException() {
		
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
