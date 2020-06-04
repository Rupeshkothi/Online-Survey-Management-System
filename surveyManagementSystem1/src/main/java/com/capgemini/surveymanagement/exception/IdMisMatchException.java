package com.capgemini.surveymanagement.exception;

import org.apache.log4j.Logger;

public class IdMisMatchException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "Id MisMatched";
	Logger logger = Logger.getLogger(IdMisMatchException.class);

	public String exceptionMessage() {
		return message;
	}
}
