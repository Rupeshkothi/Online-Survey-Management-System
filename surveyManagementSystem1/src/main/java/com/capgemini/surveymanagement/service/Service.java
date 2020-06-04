package com.capgemini.surveymanagement.service;

import java.util.List;

import com.capgemini.surveymanagement.bean.RespondentBean;
import com.capgemini.surveymanagement.bean.RespondDetails;
import com.capgemini.surveymanagement.bean.SurveyDetails;
import com.capgemini.surveymanagement.bean.SurveyorBean;

public interface Service {

	public boolean usernameValidation(String username);

	public boolean passwordValidation(String password);

	public boolean idValidation(String id);

	public boolean answerValidation(String answer);

	public boolean choiceValidation(String choice);

	public boolean titleValidation(String title);

	public boolean questionValidation(String question);

	public boolean descriptionValidation(String description);

	public boolean contactValidation(String contact);

	public boolean mailIdValidation(String mailId);

	public boolean adminLoginService(String adminUsername, String adminPassword);

	public boolean addSurveyorService(SurveyorBean surveyor);

	public boolean surveyorLoginService(String surveyorUsername, String surveyorPassword);

	public boolean createSurveyService(SurveyDetails surveyDetails);

	public boolean updateSurveyService(String surveyId);

	public boolean deleteSurveyService(String surveyId);

	public SurveyDetails viewSurveyService(String surveyTitle);

	public List<SurveyDetails> viewAllSurveysService(SurveyDetails surveyDetails);

	public boolean addRespondentService(RespondentBean respondent);

	public boolean respondentLoginService(String respondentUsername, String respondentPassword);

	public SurveyDetails respondToSurveyService(SurveyDetails surveyDetails);

	public RespondDetails viewResponseService(String respondentId);

	public List<RespondDetails> viewListOfRespondedSurveysService(RespondDetails respondentdetails);

	public List<SurveyorBean> viewAllSurveyorsService(SurveyorBean surveyor);

	public List<RespondentBean> viewAllRespondentService(RespondentBean respondent);

	public boolean answerValidation1(String answer);

	public boolean answerValidation2(String answer);
}
