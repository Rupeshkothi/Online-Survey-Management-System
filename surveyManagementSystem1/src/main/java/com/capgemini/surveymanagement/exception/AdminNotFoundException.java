package com.capgemini.surveymanagement.exception;

import org.apache.log4j.Logger;

public class AdminNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "Admin Login Failed";
	Logger logger = Logger.getLogger(AdminNotFoundException.class);

	public String exceptionMessage() {
		return message;
	}
}
