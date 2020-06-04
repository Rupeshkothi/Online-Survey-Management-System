package com.capgemini.surveymanagement.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SurveyDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SurveyDetails() {

	}

	private String surveyId;
	private String surveyTitle;
	private String surveyDescription;
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	private String question5;
	private String q1Option1;
	private String q1Option2;
	private String q1Option3;
	private String q1Option4;
	private String q2Option1;
	private String q2Option2;
	private String q2Option3;
	private String q2Option4;

	public static List<SurveyDetails> surveyDetailsRepList = new ArrayList<SurveyDetails>();

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	public String getSurveyDescription() {
		return surveyDescription;
	}

	public void setSurveyDescription(String surveyDescription) {
		this.surveyDescription = surveyDescription;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getQuestion4() {
		return question4;
	}

	public void setQuestion4(String question4) {
		this.question4 = question4;
	}

	public String getQuestion5() {
		return question5;
	}

	public void setQuestion5(String question5) {
		this.question5 = question5;
	}

	public String getQ1Option1() {
		return q1Option1;
	}

	public void setQ1Option1(String q1Option1) {
		this.q1Option1 = q1Option1;
	}

	public String getQ1Option2() {
		return q1Option2;
	}

	public void setQ1Option2(String q1Option2) {
		this.q1Option2 = q1Option2;
	}

	public String getQ1Option3() {
		return q1Option3;
	}

	public void setQ1Option3(String q1Option3) {
		this.q1Option3 = q1Option3;
	}

	public String getQ1Option4() {
		return q1Option4;
	}

	public void setQ1Option4(String q1Option4) {
		this.q1Option4 = q1Option4;
	}

	public String getQ2Option1() {
		return q2Option1;
	}

	public void setQ2Option1(String q2Option1) {
		this.q2Option1 = q2Option1;
	}

	public String getQ2Option2() {
		return q2Option2;
	}

	public void setQ2Option2(String q2Option2) {
		this.q2Option2 = q2Option2;
	}

	public String getQ2Option3() {
		return q2Option3;
	}

	public void setQ2Option3(String q2Option3) {
		this.q2Option3 = q2Option3;
	}

	public String getQ2Option4() {
		return q2Option4;
	}

	public void setQ2Option4(String q2Option4) {
		this.q2Option4 = q2Option4;
	}

	@Override
	public String toString() {
		return "SurveyDetails [surveyId=" + surveyId + "\n surveyTitle=" + surveyTitle + "\n surveyDescription="
				+ surveyDescription + "\n question1=" + question1 + "\n q1Option1=" + q1Option1
				+ "\n q1Option2=" + q1Option2 + "\n q1Option3=" + q1Option3 + "\n q1Option4=" + q1Option4
				+ "\n question2=" + question2 +  "\n  q2Option1=" + q2Option1 + "\n q2Option2=" + q2Option2
				+ "\n q2Option3=" + q2Option3 + "\n q2Option4=" + q2Option4 + "\n question3=" + question3 + "\n question4="
				+ question4 + "\n question5=" + question5 + "]";
	}

}