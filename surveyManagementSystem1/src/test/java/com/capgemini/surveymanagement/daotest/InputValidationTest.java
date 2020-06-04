package com.capgemini.surveymanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.surveymanagement.factory.Factory;
import com.capgemini.surveymanagement.validations.InputValidation;

class InputValidationTest {
	InputValidation inputValidation= Factory.getInputValidationInstance();
	@Test
	@DisplayName("usernamevalidation")
	public void testName() {
		assertEquals(true, inputValidation.usernameValidation("Admin"));
	}

	@Test
	@DisplayName("mailvalidation")
	public void testEmailValidation() {
		assertEquals(true, inputValidation.mailIdValidation("Surveyor1@gmail.com"));
	}

	@Test
	@DisplayName("surveyTitleValidation")
	public void testSurveyTitleValidation() {
		assertEquals(true, inputValidation.titleValidation("Phonepe"));
	}

	@Test
	@DisplayName("choicevalidation")
	public void testChoiceValidation() {
		assertEquals(true, inputValidation.choiceValidation("1"));
	}

	@Test
	@DisplayName("idValidation")
	public void testIdValidation() {
		assertEquals(true, inputValidation.idValidation("1"));
	}

	@Test
	@DisplayName("passwordValidation")
	public void testPasswordValidation() {
		assertEquals(true, inputValidation.passwordValidation("Admin@1"));
	}

	@Test
	@DisplayName("contactValidation")
	public void testOptionValidation() {
		assertEquals(true, inputValidation.contactValidation("4875125849"));
	}

}
