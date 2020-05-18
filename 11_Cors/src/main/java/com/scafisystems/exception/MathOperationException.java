package com.scafisystems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MathOperationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MathOperationException(String exception) {
		super(exception);
	}
	
}
