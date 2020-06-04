package com.capgemini.surveymanagement.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.surveymanagement.bean.RespondentBean;
import com.capgemini.surveymanagement.bean.RespondDetails;
import com.capgemini.surveymanagement.bean.SurveyDetails;
import com.capgemini.surveymanagement.exception.RespondentIdNotFoundException;
import com.capgemini.surveymanagement.exception.SurveyNotFoundException;
import com.capgemini.surveymanagement.exception.SurveyorNotFoundException;
import com.capgemini.surveymanagement.factory.Factory;
import com.capgemini.surveymanagement.repository.SurveyDetailsRepository;
import com.capgemini.surveymanagement.service.Service;

public class RespondentController {

	static Service service = Factory.getServiceInstance();
	static RespondentBean respondent = Factory.getRespondentBeanInstance();
	static SurveyDetails surveyDetails1 = Factory.getSurveyDetailsInstance();
	static List<SurveyDetails> surveyDetailsList = new ArrayList<SurveyDetails>();
	static List<RespondDetails> respondentDetailsList = new ArrayList<RespondDetails>();

	static List<RespondentBean> respondentList = new ArrayList<RespondentBean>();
	static final Logger logger = Logger.getLogger(RespondentController.class);
	static Scanner sc = new Scanner(System.in);
	static RespondDetails respondentDetails = Factory.getRespondentDetailsInstance();
	static int count = 0;

	private RespondentController() {

	}

	public static void respondentLogin() {

		try {
			FileReader reader1 = new FileReader("db.properties");
			Properties p = new Properties();
			try {
				p.load(reader1);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					reader1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		logger.info("Enter username: ");
		String respondentUsername;
		respondentUsername = sc.next();
		while (!service.usernameValidation(respondentUsername)) {
			logger.info("Please Enter Valid  username ");
			respondentUsername = sc.next();
		}
		logger.info("Enter password: ");
		String respondentPassword;
		respondentPassword = sc.next();
		while (!service.passwordValidation(respondentPassword)) {
			logger.info("Please Enter Valid  password ");
			respondentPassword = sc.next();
		}
		try {
			boolean value2 = service.respondentLoginService(respondentUsername, respondentPassword);
			if (value2) {
				logger.info("Respondent Login Successful");
				afterRespondentLogin();
			} else {
				throw new SurveyorNotFoundException();
			}
		} catch (SurveyorNotFoundException e) {
			logger.info("Login Failed!");
			logger.info("Please enter Valid UserName or Password!!");
			respondentLogin();
		}
	}

	public static void afterRespondentLogin() {

		boolean flag = true;
		do {
			logger.info("1.Respond to Survey");
			logger.info("2.View Response");
			logger.info("3.View all responded surveys");
			logger.info("4.Exit");
			String option = sc.next();
			while (!service.choiceValidation(option)) {
				logger.info("please enter valid choice: Accepts only [1-4] ");
				option = sc.next();
			}
			int select = Integer.parseInt(option);

			switch (select) {

			case 1:
				logger.info("Respond to survey");
				respondToSurvey();
				break;
			case 2:
				logger.info("View Response");
				viewResponse();
				break;
			case 3:
				logger.info("view All Responded Surveys");
				viewAllRespondedSurveys();
				break;
			case 4:
				flag = false;
				logger.info("Logged Out Successfully");
				MainController.main(null);
				break;
			default:
				flag = !flag;
				logger.info("Enter valid choice");
				break;
			}
		} while (!flag);
	}

	public static void respondToSurvey() {
		logger.info("Enter surveyId to respond:which must be between [0-9] and min 1 and max 10");
		String surveyId = sc.next();
		while (!service.idValidation(surveyId)) {
			logger.info("Enter valid SurveyId: which must be between [0-9] and min 1 and max 10");
			surveyId = sc.next();
		}
		for (SurveyDetails surveyDetails : SurveyDetailsRepository.defaultSurveyorSurvey()) {
			logger.info("1. " + surveyDetails.getQuestion1());
			logger.info("Select your option");
			logger.info("1. " + surveyDetails.getQ1Option1());
			logger.info("2. " + surveyDetails.getQ1Option2());
			logger.info("3. " + surveyDetails.getQ1Option3());
			logger.info("4. " + surveyDetails.getQ1Option4());
			logger.info("submit your option:from [1-4]");
			String answer1 = sc.next();
			while (!service.choiceValidation(answer1)) {
				logger.info("Enter a valid option:from [1-4]");
				answer1 = sc.next();
			}
			int ans1 = Integer.parseInt(answer1);
			if (ans1 == 1)
				respondentDetails.setAnswer1(surveyDetails.getQ1Option1());
			if (ans1 == 2)
				respondentDetails.setAnswer1(surveyDetails.getQ1Option2());
			if (ans1 == 3)
				respondentDetails.setAnswer1(surveyDetails.getQ1Option3());
			if (ans1 == 4)
				respondentDetails.setAnswer1(surveyDetails.getQ1Option4());

			logger.info("2. " + surveyDetails.getQuestion2());
			logger.info("Select your option");
			logger.info("1. " + surveyDetails.getQ2Option1());
			logger.info("2. " + surveyDetails.getQ2Option2());
			logger.info("3. " + surveyDetails.getQ2Option3());
			logger.info("4. " + surveyDetails.getQ2Option4());
			logger.info("submit your option from [1-4]");
			String answer2 = sc.next();
			while (!service.choiceValidation(answer2)) {
				logger.info("Enter a valid option from [1-4]");
				answer2 = sc.next();
			}
			int ans2 = Integer.parseInt(answer2);
			if (ans2 == 1)
				respondentDetails.setAnswer2(surveyDetails.getQ2Option1());
			if (ans2 == 2)
				respondentDetails.setAnswer2(surveyDetails.getQ2Option2());
			if (ans2 == 3)
				respondentDetails.setAnswer2(surveyDetails.getQ2Option3());
			if (ans2 == 4)
				respondentDetails.setAnswer2(surveyDetails.getQ2Option4());
			logger.info("3. " + surveyDetails.getQuestion3());
			logger.info("Enter your Rating :");
			String answer3 = sc.next();
			while (!service.answerValidation1(answer3)) {
				logger.info("Enter a valid Rating between the range 0-10 ");
				answer3 = sc.next();
				respondentDetails.setAnswer3(answer3);
			}
			logger.info("4. " + surveyDetails.getQuestion4());
			logger.info("Enter your answer :");
			String answer4 = sc.next();
			while (!service.answerValidation(answer4)) {
				logger.info("Enter a valid Answer: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 20");
				answer4 = sc.next();
				respondentDetails.setAnswer4(answer4);
			}
			logger.info("5. " + surveyDetails.getQuestion5());
			logger.info("Enter your answer :");
			String answer5 = sc.next();
			while (!service.answerValidation(answer5)) {
				logger.info("Enter a valid Answer: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
				answer5 = sc.next();
				respondentDetails.setAnswer5(answer5);
			}
			logger.info("Responses added Successfully");

			afterRespondentLogin();
			try {
				SurveyDetails responseView = service.viewSurveyService(surveyId);
				logger.info(responseView);

			} catch (SurveyNotFoundException e) {
				logger.error(e.exceptionMessage());
			}
		}
	}

	public static List<RespondDetails> viewResponse() {
		Service service = Factory.getServiceInstance();
		logger.info("please enter respondentId to view:");
		String respondentId = sc.next();
		while (!service.idValidation(respondentId)) {
			logger.info("enter valid respondentId: which must be between [0-9] and min 1 and max 10");
			respondentId = sc.next();
		}
		RespondDetails respondDetails = Factory.getServiceInstance().viewResponseService(respondentId);
		try {
			if (respondDetails != null) {
				logger.info(respondDetails);
				afterRespondentLogin();
			} else {
				throw new RespondentIdNotFoundException();
			}
		} catch (RespondentIdNotFoundException e) {
			logger.error(e.exceptionMessage());
			afterRespondentLogin();
		}
		return respondentDetailsList;
	}

	public static List<RespondDetails> viewAllRespondedSurveys() {
		logger.info("view all Responded Surveys");
		logger.info(service.viewListOfRespondedSurveysService(respondentDetails));
		afterRespondentLogin();
		return respondentDetailsList;

	}

}
