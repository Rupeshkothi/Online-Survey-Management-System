package com.capgemini.surveymanagement.exception;

import org.apache.log4j.Logger;

public class SurveyorNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "Surveyor Login Failed";
	Logger logger = Logger.getLogger(SurveyorNotFoundException.class);

	public String exceptionMessage() {
		return message;
	}
}
