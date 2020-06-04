package com.capgemini.surveymanagement.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.surveymanagement.bean.SurveyDetails;
import com.capgemini.surveymanagement.factory.Factory;

public class SurveyDetailsRepository {

	public static List<SurveyDetails> defaultSurveyorSurvey() {
		List<SurveyDetails> surveyDetailsRepList = new ArrayList<SurveyDetails>();
		SurveyDetails surveyDetails = Factory.getSurveyDetailsInstance();
		surveyDetails.setSurveyId("1");
		surveyDetails.setSurveyTitle("Big Basket");
		surveyDetails.setSurveyDescription("Big Basket is the Online supermarket,It offers "
				+ "groceries,Food,Vegetables...any many more for its customers");

		surveyDetails.setQuestion1("How much you are Satisfied with Our Big Basket Application ");
		surveyDetails.setQ1Option1("Good");
		surveyDetails.setQ1Option2("Not Bad");
		surveyDetails.setQ1Option3("Very Good");
		surveyDetails.setQ1Option4("Bad");
		surveyDetails.setQuestion2("How is our delivery service");
		surveyDetails.setQ2Option1("Good");
		surveyDetails.setQ2Option2("Not Bad");
		surveyDetails.setQ2Option3("Very Good");
		surveyDetails.setQ2Option4("Bad");

		surveyDetails.setQuestion3("Please rate us from [0-10]");
		surveyDetails.setQuestion4("If,Any complaints regarding our app please mention");
		surveyDetails.setQuestion5("Please Share Your Experience with Our Big Basket App");

		surveyDetailsRepList.add(surveyDetails);
		return surveyDetailsRepList;

	}
}
