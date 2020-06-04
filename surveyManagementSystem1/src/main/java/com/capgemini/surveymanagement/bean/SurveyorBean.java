package com.capgemini.surveymanagement.bean;

import java.io.Serializable;

public class SurveyorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SurveyorBean() {

	}

	private String surveyorId;
	private String surveyorUsername;
	private String surveyorPassword;
	private String surveyorContactNumber;
	private String surveyorMailId;

	public String getSurveyorId() {
		return surveyorId;
	}

	public void setSurveyorId(String surveyorId) {
		this.surveyorId = surveyorId;
	}

	public String getSurveyorContactNumber() {
		return surveyorContactNumber;
	}

	public void setSurveyorContactNumber(String surveyorContactNumber) {
		this.surveyorContactNumber = surveyorContactNumber;
	}

	public String getSurveyorMailId() {
		return surveyorMailId;
	}

	public void setSurveyorMailId(String surveyorMailId) {
		this.surveyorMailId = surveyorMailId;
	}

	public String getSurveyorUsername() {
		return surveyorUsername;
	}

	public void setSurveyorUsername(String surveyorUsername) {
		this.surveyorUsername = surveyorUsername;
	}

	public String getSurveyorPassword() {
		return surveyorPassword;
	}

	public void setSurveyorPassword(String surveyorPassword) {
		this.surveyorPassword = surveyorPassword;
	}

	@Override
	public String toString() {
		return "SurveyorBean [surveyorId=" + surveyorId + ", surveyorUsername=" + surveyorUsername
				+ ", surveyorPassword=" + surveyorPassword + ", surveyorContactNumber=" + surveyorContactNumber
				+ ", surveyorMailId=" + surveyorMailId + "]";
	}

}
