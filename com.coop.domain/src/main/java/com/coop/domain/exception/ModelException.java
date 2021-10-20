package com.coop.domain.exception;

public class ModelException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public  ModelException(){
		super();
	}
	
	public  ModelException(Exception e){
		super(e.getMessage());
	}
	
	public  ModelException(String msg){
		super(msg);
	}
	
}
