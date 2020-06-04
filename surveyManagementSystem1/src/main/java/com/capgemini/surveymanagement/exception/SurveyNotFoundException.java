package com.capgemini.surveymanagement.exception;

import org.apache.log4j.Logger;

public class SurveyNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "Survey Not Found";
	Logger logger = Logger.getLogger(SurveyNotFoundException.class);

	public String exceptionMessage() {
		return message;
	}
}
