package com.capgemini.surveymanagement.factory;

import com.capgemini.surveymanagement.bean.AdminBean;
import com.capgemini.surveymanagement.bean.RespondentBean;
import com.capgemini.surveymanagement.bean.RespondDetails;
import com.capgemini.surveymanagement.bean.SurveyDetails;
import com.capgemini.surveymanagement.bean.SurveyorBean;
import com.capgemini.surveymanagement.dao.Dao;
import com.capgemini.surveymanagement.dao.DaoImplementation;
import com.capgemini.surveymanagement.service.Service;
import com.capgemini.surveymanagement.service.ServiceImplementation;
import com.capgemini.surveymanagement.validations.InputValidation;
import com.capgemini.surveymanagement.validations.InputValidationImplementation;

public class Factory {
	private Factory() {

	}

	public static AdminBean getAdminBeanInstance() {
		return new AdminBean();
	}

	public static SurveyorBean getSurveyorBeanInstance() {
		return new SurveyorBean();
	}

	public static RespondentBean getRespondentBeanInstance() {
		return new RespondentBean();
	}

	public static SurveyDetails getSurveyDetailsInstance() {
		return new SurveyDetails();

	}

	public static RespondDetails getRespondentDetailsInstance() {
		return new RespondDetails();
	}

	public static Dao getDaoInstance() {
		return new DaoImplementation();
	}

	public static InputValidation getInputValidationInstance() {
		return new InputValidationImplementation();
	}

	public static Service getServiceInstance() {
		return new ServiceImplementation();

	}

}
