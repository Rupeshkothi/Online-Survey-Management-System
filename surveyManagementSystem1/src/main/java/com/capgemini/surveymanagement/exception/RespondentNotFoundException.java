package com.capgemini.surveymanagement.exception;

import org.apache.log4j.Logger;

public class RespondentNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "Respondent Login Failed";
	Logger logger = Logger.getLogger(RespondentNotFoundException.class);

	public String exceptionMessage() {
		return message;
	}
}
