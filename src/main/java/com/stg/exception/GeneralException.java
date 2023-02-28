package com.stg.exception;

public class GeneralException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public GeneralException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {

		return this.errorMessage;
	}

}
