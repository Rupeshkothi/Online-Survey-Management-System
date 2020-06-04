package com.capgemini.surveymanagement.daotest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.capgemini.surveymanagement.bean.AdminBean;
import com.capgemini.surveymanagement.bean.RespondentBean;
import com.capgemini.surveymanagement.bean.RespondDetails;
import com.capgemini.surveymanagement.bean.SurveyDetails;
import com.capgemini.surveymanagement.bean.SurveyorBean;
import com.capgemini.surveymanagement.dao.Dao;
import com.capgemini.surveymanagement.dao.DaoImplementation;
import com.capgemini.surveymanagement.factory.Factory;

class DaoTest {
	SurveyorBean surveyor = Factory.getSurveyorBeanInstance();
	AdminBean admin = Factory.getAdminBeanInstance();
	RespondentBean respondent = Factory.getRespondentBeanInstance();
	RespondDetails respondentDetails = Factory.getRespondentDetailsInstance();
	SurveyDetails surveyDetails = Factory.getSurveyDetailsInstance();
	Dao dao = new DaoImplementation();

	@Test
	@DisplayName("Admin Login")
	void testAdminLogin() {
		assertEquals(true, dao.adminLogin("admin", "admin"));
	}

	@Test
	@DisplayName("Add Surveyor")
	void testAddSurveyor() {
		assertNotNull(surveyor);
	}

	@Test
	@DisplayName("create Survey")
	void testCreateSurvey() {
		assertNotNull(surveyDetails);
	}

	@Test
	@DisplayName("update Survey")
	void testUpdateSurvey() {
		assertEquals(false, dao.updateSurvey("1"));
	}

	@Test
	@DisplayName("delete Survey")
	void testDeleteSurvey() {
		assertEquals(false, dao.deleteSurvey("1"));
	}

	@Test
	@DisplayName("view Survey")
	void testViewSurvey() {
		assertEquals(false, dao.viewSurvey("Phonepe"));
	}

	@Test
	@DisplayName("view all surveyes")
	void testViewAllSurvey() {
		assertNotNull(surveyDetails);
	}

	@Test
	@DisplayName("Add Respondent")
	void testAddRespondent() {
		assertNotNull(respondent);
	}

	@Test
	@DisplayName("Respondent Login")
	void testRespondentLogin() {
		assertEquals(false, dao.respondentLogin("Respondent", "Respondent@1"));
	}

	@Test
	@DisplayName("Respondent To Survey")
	void testRespondToSurvey() {
		assertNotNull(surveyDetails);
	}

	@Test
	@DisplayName("View Response")
	void testViewResponse() {
		assertEquals(false, dao.viewResponse("1"));
	}

	@Test
	@DisplayName("view List Of Responded Surveys")
	void testViewListOfRespondedSurvey() {
		assertNotNull(respondentDetails);
	}

}