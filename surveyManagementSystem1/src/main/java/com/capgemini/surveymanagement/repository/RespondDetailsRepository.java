package com.capgemini.surveymanagement.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.surveymanagement.bean.RespondDetails;
import com.capgemini.surveymanagement.factory.Factory;

public class RespondDetailsRepository {
	public List<RespondDetails> defaultRespondentResponse() {
		List<RespondDetails> respondentDetailsRepList = new ArrayList<>();
		RespondDetails respondentDetails= Factory.getRespondentDetailsInstance();
		respondentDetails.setRespondentId("1");
		respondentDetails.setSurveyId("1");
		respondentDetails.setAnswer1("Good");
		respondentDetails.setAnswer2("Not Bad");
		respondentDetails.setAnswer3("4.5");
		respondentDetails.setAnswer4("Delivery time for products can be improved");
		respondentDetails.setAnswer5("The Experience with this application is really good but if some changes are made"
				+ "it will be too good");

		respondentDetailsRepList.add(respondentDetails);

		RespondDetails respondentDetails1 = Factory.getRespondentDetailsInstance();
		 respondentDetails1.setRespondentId("2");
		 respondentDetails1.setSurveyId("2");
		 respondentDetails1.setAnswer1("Very Good");
		 respondentDetails1.setAnswer2("Good");
		 respondentDetails1.setAnswer3("3.0");
		 respondentDetails1.setAnswer4("Sometimes the application is not working properly");
		 respondentDetails1.setAnswer5(
				"Phonepe is really Good it made our day easy with single click " + 
		"we are able to made transactions");
		respondentDetailsRepList.add( respondentDetails1);
		return respondentDetailsRepList;
	}

}
