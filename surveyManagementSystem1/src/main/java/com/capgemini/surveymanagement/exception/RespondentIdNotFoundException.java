package com.capgemini.surveymanagement.exception;

import org.apache.log4j.Logger;

public class RespondentIdNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "Respondent ID Not Found";
	Logger logger = Logger.getLogger(RespondentIdNotFoundException.class);

	public String exceptionMessage() {
		return message;
	}

}
