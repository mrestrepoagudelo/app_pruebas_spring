package com.coop.domain.exception;

public class ModelExceptionDos extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ModelExceptionDos() {
		super();
	}

	public ModelExceptionDos(Exception e) {
		super(e.getMessage());
	}

	public ModelExceptionDos(String msg) {
		super(msg);
	}

}
