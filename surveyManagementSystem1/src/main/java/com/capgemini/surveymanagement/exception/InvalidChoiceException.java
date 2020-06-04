package com.capgemini.surveymanagement.exception;

import org.apache.log4j.Logger;

public class InvalidChoiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "Invalid Choice Exception";
	Logger logger = Logger.getLogger(InvalidChoiceException.class);

	public String exceptionMessage() {
		return message;
	}
}
