package com.capgemini.surveymanagement.dao;

import java.util.List;

import com.capgemini.surveymanagement.bean.RespondentBean;
import com.capgemini.surveymanagement.bean.RespondDetails;
import com.capgemini.surveymanagement.bean.SurveyDetails;
import com.capgemini.surveymanagement.bean.SurveyorBean;

public interface Dao {

	public boolean adminLogin(String adminUsername, String adminPassword);

	public boolean addSurveyor(SurveyorBean surveyor);

	public boolean surveyorLogin(String surveyorUsername, String surveyorPassword);

	public boolean createSurvey(SurveyDetails surveydetails);

	public boolean updateSurvey(String surveyId);

	public boolean deleteSurvey(String surveyTitle);

	public SurveyDetails viewSurvey(String surveyTitle);

	public List<SurveyDetails> viewAllSurveys(SurveyDetails surveyDetails);

	public boolean addRespondent(RespondentBean respondent);

	public boolean respondentLogin(String respondentUsername, String respondentPassword);

	public SurveyDetails respondToSurvey(SurveyDetails surveyDetails);

	public RespondDetails viewResponse(String respondentId);

	public List<RespondDetails> viewListOfRespondedSurveys(RespondDetails respondentdetails);

	public List<SurveyorBean> viewAllSurveyors(SurveyorBean surveyor);

	public List<RespondentBean> viewAllRespondents(RespondentBean respondent);

	public SurveyDetails getSurvey(String surveyId);
}
