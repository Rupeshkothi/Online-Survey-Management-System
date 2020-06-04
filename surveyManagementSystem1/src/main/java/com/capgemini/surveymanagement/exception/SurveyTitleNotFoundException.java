package com.capgemini.surveymanagement.exception;

import org.apache.log4j.Logger;

public class SurveyTitleNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "Survey Title Not Found";
	Logger logger = Logger.getLogger(SurveyTitleNotFoundException.class);

	public String exceptionMessage() {
		return message;
	}

}
