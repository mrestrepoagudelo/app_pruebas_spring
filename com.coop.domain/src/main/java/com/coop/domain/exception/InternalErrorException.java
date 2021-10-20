package com.coop.domain.exception;

public class InternalErrorException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public  InternalErrorException(){
		super();
	}
	
	public  InternalErrorException(Exception e){
		super(e.getMessage());
	}
	
	public  InternalErrorException(String msg){
		super(msg);
	}
}
