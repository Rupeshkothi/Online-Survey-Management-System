package com.capgemini.surveymanagement.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RespondDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RespondDetails() {

	}

	private String respondentId;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;
	private String surveyId;

	List<RespondDetails> respondentDetailsRepList = new ArrayList<>();
	public String getRespondentId() {
		return respondentId;
	}

	public void setRespondentId(String string) {
		this.respondentId = string;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String string) {
		this.answer1 = string;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getAnswer5() {
		return answer5;
	}

	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	@Override
	public String toString() {
		return "RespondentDetails [respondentId=" + respondentId + "\n answer1=" + answer1 + "\n answer2=" + answer2
				+ "\n answer3=" + answer3 + " \n answer4=" + answer4 + " \n answer5=" + answer5 + "\n surveyId=" + surveyId
				+ "]";
	}

}