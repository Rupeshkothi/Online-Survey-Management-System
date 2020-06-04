package com.capgemini.surveymanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.surveymanagement.bean.AdminBean;
import com.capgemini.surveymanagement.bean.RespondentBean;
import com.capgemini.surveymanagement.bean.RespondDetails;
import com.capgemini.surveymanagement.bean.SurveyDetails;
import com.capgemini.surveymanagement.bean.SurveyorBean;
import com.capgemini.surveymanagement.factory.Factory;
import com.capgemini.surveymanagement.service.Service;

class ServiceTest {
	SurveyorBean surveyor = Factory.getSurveyorBeanInstance();
	AdminBean admin = Factory.getAdminBeanInstance();
	RespondentBean respondent = Factory.getRespondentBeanInstance();
	RespondDetails respondentDetails = Factory.getRespondentDetailsInstance();
	SurveyDetails surveyDetails = Factory.getSurveyDetailsInstance();
	Service service = Factory.getServiceInstance();

	@Test
	@DisplayName("Admin Login")
	void testAdminLoginService() {
		assertEquals(true, service.adminLoginService("Admin", "Admin@1"));
	}

	@Test
	@DisplayName("Add Surveyor")
	void testAddSurveyorService() {
		assertNotNull(surveyor);
	}

	@Test
	@DisplayName("create Survey")
	void testCreateSurveyService() {
		assertNotNull(surveyDetails);
	}

	@Test
	@DisplayName("update Survey")
	void testUpdateSurveyService() {
		assertEquals(false, service.updateSurveyService("1"));
	}

	@Test
	@DisplayName("delete Survey")
	void testDeleteSurvey() {
		assertEquals(false, service.deleteSurveyService("1"));
	}

	@Test
	@DisplayName("view Survey")
	void testViewSurvey() {
		assertEquals(false, service.viewSurveyService("Phonepe"));
	}

	@Test
	@DisplayName("view all surveys")
	void testViewAllSurveyService() {
		assertNotNull(surveyDetails);
	}

	@Test
	@DisplayName("Add Respondent")
	void testAddRespondentService() {
		assertNotNull(respondent);
	}

	@Test
	@DisplayName("Respondent Login")
	void testRespondentLoginService() {
		assertEquals(false, service.respondentLoginService("Respondent", "Respondent@1"));
	}

	@Test
	@DisplayName("Respondent To Survey")
	void testRespondToSurveyService() {
		assertNotNull(surveyDetails);
	}

	@Test
	@DisplayName("View Response")
	void testViewResponseService() {
		assertEquals(false, service.viewResponseService("1"));
	}

	@Test
	@DisplayName("view List Of Responded Surveys")
	void testViewListOfRespondedSurveyService() {
		assertNotNull(respondentDetails);
	}

}
