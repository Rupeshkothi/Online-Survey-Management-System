package com.capgemini.surveymanagement.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RespondentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RespondentBean() {

	}

	private String respondentUsername;
	private String respondentPassword;
	private String respondentContactNumber;
	private String respondentMailId;

	public static List<RespondentBean> respondentRepList = new ArrayList<>();
	public String getRespondentContactNumber() {
		return respondentContactNumber;
	}

	public void setRespondentContactNumber(String respondentContactNumber) {
		this.respondentContactNumber = respondentContactNumber;
	}

	public String getRespondentMailId() {
		return respondentMailId;
	}

	public void setRespondentMailId(String respondentMailId) {
		this.respondentMailId = respondentMailId;
	}

	public String getRespondentUsername() {
		return respondentUsername;
	}

	public void setRespondentUsername(String respondentUsername) {
		this.respondentUsername = respondentUsername;
	}

	public String getRespondentPassword() {
		return respondentPassword;
	}

	public void setRespondentPassword(String respondentPassword) {
		this.respondentPassword = respondentPassword;
	}

	@Override
	public String toString() {
		return "RespondentBean [respondentUsername=" + respondentUsername + "\n respondentPassword=" + respondentPassword
				+ "\n respondentContactNumber=" + respondentContactNumber + "\n respondentMailId=" + respondentMailId
				+ "]";
	}

}
