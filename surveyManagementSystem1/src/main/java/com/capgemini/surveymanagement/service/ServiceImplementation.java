package com.capgemini.surveymanagement.service;

import java.util.List;

import com.capgemini.surveymanagement.bean.RespondentBean;
import com.capgemini.surveymanagement.bean.RespondDetails;
import com.capgemini.surveymanagement.bean.SurveyDetails;
import com.capgemini.surveymanagement.bean.SurveyorBean;
import com.capgemini.surveymanagement.dao.Dao;
import com.capgemini.surveymanagement.factory.Factory;
import com.capgemini.surveymanagement.validations.InputValidation;

public class ServiceImplementation implements Service {
	InputValidation inputvalidation = Factory.getInputValidationInstance();
	Dao dao = Factory.getDaoInstance();

	public boolean usernameValidation(String username) {
		if (username != null) {
			return inputvalidation.usernameValidation(username);
		}
		return false;
	}

	public boolean passwordValidation(String password) {
		if (password != null) {
			return inputvalidation.passwordValidation(password);
		}
		return false;
	}

	public boolean idValidation(String id) {
		if (id != null) {
			return inputvalidation.idValidation(id);
		}
		return false;
	}

	public boolean answerValidation(String answer) {
		if (answer != null) {
			return inputvalidation.answerValidation(answer);
		}
		return false;
	}

	public boolean choiceValidation(String choice) {
		if (choice != null) {
			return inputvalidation.choiceValidation(choice);
		}
		return false;
	}

	public boolean titleValidation(String title) {
		if (title != null) {
			return inputvalidation.titleValidation(title);
		}
		return false;
	}

	public boolean questionValidation(String question) {
		if (question != null) {
			return inputvalidation.questionValidation(question);
		}
		return false;
	}

	public boolean descriptionValidation(String description) {
		if (description != null) {
			return inputvalidation.descriptionValidation(description);
		}
		return false;
	}

	public boolean contactValidation(String contact) {
		if (contact != null) {
			return inputvalidation.contactValidation(contact);
		}
		return false;
	}

	public boolean mailIdValidation(String mailId) {
		if (mailId != null) {
			return inputvalidation.mailIdValidation(mailId);
		}
		return false;
	}

	public boolean adminLoginService(String adminUsername, String adminPassword) {
		if ((adminUsername != null) && (adminPassword != null)) {
			return dao.adminLogin(adminUsername, adminPassword);
		}
		return false;
	}

	public boolean addSurveyorService(SurveyorBean surveyor) {
		if (surveyor != null) {
			return dao.addSurveyor(surveyor);
		}
		return false;
	}

	public boolean surveyorLoginService(String surveyorUsername, String surveyorPassword) {
		if ((surveyorUsername != null) && (surveyorPassword != null)) {
			return dao.surveyorLogin(surveyorUsername, surveyorPassword);
		}
		return false;
	}

	public boolean createSurveyService(SurveyDetails surveyDetails) {
		if (surveyDetails != null) {
			return dao.createSurvey(surveyDetails);
		}
		return false;
	}

	public boolean updateSurveyService(String surveyId) {
		if (surveyId != null) {
			return dao.updateSurvey(surveyId);
		}
		return false;
	}

	public boolean deleteSurveyService(String surveyId) {
		if (surveyId != null) {
			return dao.deleteSurvey(surveyId);
		}
		return false;
	}

	public SurveyDetails viewSurveyService(String surveyTitle) {
		if (surveyTitle != null) {
			return dao.viewSurvey(surveyTitle);
		}
		return null;
	}

	public List<SurveyDetails> viewAllSurveysService(SurveyDetails surveyDetails) {
		if (surveyDetails != null) {
			return dao.viewAllSurveys(surveyDetails);
		}
		return null;

	}

	public boolean addRespondentService(RespondentBean respondent) {
		if (respondent != null) {
			return dao.addRespondent(respondent);
		}
		return false;
	}

	public boolean respondentLoginService(String respondentUsername, String respondentPassword) {
		if ((respondentUsername != null) && (respondentPassword != null)) {
			return dao.respondentLogin(respondentUsername, respondentPassword);
		}
		return false;
	}

	public SurveyDetails respondToSurveyService(SurveyDetails surveyDetails) {
		if (surveyDetails != null) {
			return dao.respondToSurvey(surveyDetails);
		}
		return surveyDetails;
	}

	public RespondDetails viewResponseService(String respondentId) {
		if (respondentId != null) {
			return dao.viewResponse(respondentId);
		}
		return null;
	}

	public List<RespondDetails> viewListOfRespondedSurveysService(RespondDetails respondentDetails) {
		if (respondentDetails != null) {
			return dao.viewListOfRespondedSurveys(respondentDetails);
		}
		return null;
	}

	@Override
	public List<SurveyorBean> viewAllSurveyorsService(SurveyorBean surveyor) {
		if (surveyor != null) {
			return dao.viewAllSurveyors(surveyor);
		}
		return null;
	}

	@Override
	public List<RespondentBean> viewAllRespondentService(RespondentBean respondent) {
		if (respondent != null) {
			return dao.viewAllRespondents(respondent);
		}
		return null;
	}

	@Override
	public boolean answerValidation1(String answer) {
		if (answer != null) {
			return inputvalidation.answerValidation1(answer);
		}
		return false;
	}

	@Override
	public boolean answerValidation2(String answer) {
		if (answer != null) {
			return inputvalidation.answerValidation1(answer);
		}
		return false;
	}

}