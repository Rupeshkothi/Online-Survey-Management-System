package com.capgemini.surveymanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.surveymanagement.bean.AdminBean;
import com.capgemini.surveymanagement.bean.RespondentBean;
import com.capgemini.surveymanagement.bean.RespondDetails;
import com.capgemini.surveymanagement.bean.SurveyDetails;
import com.capgemini.surveymanagement.bean.SurveyorBean;
import com.capgemini.surveymanagement.repository.AdminRepository;
import com.capgemini.surveymanagement.repository.RespondDetailsRepository;
import com.capgemini.surveymanagement.repository.RespondentRepository;
import com.capgemini.surveymanagement.repository.SurveyDetailsRepository;
import com.capgemini.surveymanagement.repository.SurveyorRepository;

public class DaoImplementation implements Dao {

	static List<AdminBean> adminList = new ArrayList<>();
	static List<SurveyorBean> surveyorList = new ArrayList<>();
	static List<RespondentBean> respondentList = new ArrayList<>();
	static List<RespondDetails> respondentDetailsList = new ArrayList<>();
	static List<SurveyDetails> surveyDetailsList = new ArrayList<>();
	int count = 0;
	String idSurvey = "surveyId";

	public DaoImplementation() {
		super();
	}

	static {
		List<AdminBean> admin = new AdminRepository().defaultAdminLogin();
		adminList.addAll(admin);
		List<SurveyorBean> surveyor = new SurveyorRepository().defaultSurveyorLogin();
		surveyorList.addAll(surveyor);
		List<SurveyDetails> surveyDetails = new SurveyDetailsRepository().defaultSurveyorSurvey();
		surveyDetailsList.addAll(surveyDetails);
		List<RespondentBean> respondent = new RespondentRepository().defaultRespondentLogin();
		respondentList.addAll(respondent);
		List<RespondDetails> respondentDetails = new RespondDetailsRepository().defaultRespondentResponse();
		respondentDetailsList.addAll(respondentDetails);

	}

	/**
	 * This method is used for admin Login.
	 */
	public boolean adminLogin(String adminUsername, String adminPassword) {
		for (AdminBean admin : adminList) {
			if (admin.getAdminUsername().equals(adminUsername) && admin.getAdminPassword().equals(adminPassword)) {
				count++;
			}
		}
		return count != 0;
	}

	/**
	 * This method is used to add a new Surveyor.
	 */
	public boolean addSurveyor(SurveyorBean surveyor) {
		int surveyorListSize = SurveyorRepository.surveyorList.size();
		SurveyorRepository.surveyorList.add(surveyor);
		return surveyorListSize != SurveyorRepository.surveyorList.size() + 1;

	}

	/**
	 * This method is used for surveyor to login.
	 */
	public boolean surveyorLogin(String surveyorUsername, String surveyorPassword) {
		for (SurveyorBean surveyor : surveyorList) {
			if (surveyor.getSurveyorUsername().equals(surveyorUsername)
					&& surveyor.getSurveyorPassword().equals(surveyorPassword)) {
				count++;
			}
		}
		return count != 0;
	}

	/**
	 * This method is used to create a survey.
	 */
	public boolean createSurvey(SurveyDetails surveyDetails) {
		int surveyDetailsListSize = surveyDetailsList.size();
		surveyDetailsList.add(surveyDetails);
		return surveyDetailsListSize != surveyDetailsList.size() + 1;

	}

	/**
	 * This method is used to update the survey.
	 */
	public boolean updateSurvey(String surveyId) {
		for (SurveyDetails updateSurvey : surveyDetailsList) {
			if (updateSurvey.getSurveyId().equals(surveyId)) {
				count++;
			}
		}
		return count != 0;

	}

	public SurveyDetails getSurvey(String surveyId) {
		for (SurveyDetails updateSurvey : surveyDetailsList) {
			if (updateSurvey.getSurveyId().equals(surveyId)) {
				return updateSurvey;
			}
		}
		return null;

	}

	/**
	 * This method is used to delete the survey.
	 */
	public boolean deleteSurvey(String idSurvey) {

		for (SurveyDetails deleteSurvey : surveyDetailsList) {
			if (deleteSurvey.getSurveyId().equals(idSurvey)) {

				surveyDetailsList.remove(deleteSurvey);
				count++;
				break;
			}
		}
		return count != 0;
	}

	/**
	 * This method is used to view the created survey.
	 * 
	 * @return
	 */
	public SurveyDetails viewSurvey(String surveyTitle) {
		for (SurveyDetails surveyDetails : surveyDetailsList)
			if (surveyDetails.getSurveyTitle().equals(surveyTitle)) {
				return surveyDetails;

			}
		return null;
	}

	/**
	 * This method is used to view all the surveys.
	 */
	public List<SurveyDetails> viewAllSurveys(SurveyDetails surveyDetails) {
		return surveyDetailsList;
	}

	/**
	 * This method is used to Add Respondent.
	 */
	public boolean addRespondent(RespondentBean respondent) {
		int respondentListSize = respondentList.size();
		respondentList.add(respondent);
		return respondentListSize != respondentList.size() + 1;

	}

	/**
	 * This method is used for the Respondent to login.
	 */
	public boolean respondentLogin(String respondentUsername, String respondentPassword) {
		for (RespondentBean respondent : respondentList) {
			if (respondent.getRespondentUsername().equals(respondentUsername)
					&& respondent.getRespondentPassword().equals(respondentPassword)) {
				count++;
			}
		}
		return count != 0;

	}

	/**
	 * This method is used to view all the list of responded surveys.
	 */
	public List<RespondDetails> viewListOfRespondedSurveys(RespondDetails respondentdetails) {
		return respondentDetailsList;
	}

	/**
	 * This method is used to view the response.
	 */
	public RespondDetails viewResponse(String respondentId) {

		for (RespondDetails viewResponse : respondentDetailsList) {
			if (viewResponse.getRespondentId().equals(respondentId)) {
				return viewResponse;
			}
		}
		return null;
	}

	/**
	 * This method is used to respond to a survey.
	 */
	public SurveyDetails respondToSurvey(SurveyDetails surveyDetails) {
		for (SurveyDetails respondToSurvey : surveyDetailsList)
			if (respondToSurvey.getSurveyTitle().equals(surveyDetails)) {
				count++;
			}
		return surveyDetails;
	}

	/**
	 * This method is used to view all surveyors.
	 */
	@Override
	public List<SurveyorBean> viewAllSurveyors(SurveyorBean surveyor) {
		return SurveyorRepository.surveyorList;

	}

	/**
	 * This method is used to view all Respondents.
	 */
	@Override
	public List<RespondentBean> viewAllRespondents(RespondentBean respondent) {
		return respondentList;
	}

}
