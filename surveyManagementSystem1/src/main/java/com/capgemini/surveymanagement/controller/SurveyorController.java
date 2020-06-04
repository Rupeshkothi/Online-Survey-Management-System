package com.capgemini.surveymanagement.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.surveymanagement.bean.SurveyDetails;
import com.capgemini.surveymanagement.bean.SurveyorBean;
import com.capgemini.surveymanagement.factory.Factory;
import com.capgemini.surveymanagement.service.Service;
import com.capgemini.surveymanagement.exception.IdMisMatchException;
import com.capgemini.surveymanagement.exception.SurveyNotFoundException;
import com.capgemini.surveymanagement.exception.SurveyTitleNotFoundException;
import com.capgemini.surveymanagement.exception.SurveyorNotFoundException;

public class SurveyorController {
	private SurveyorController() {

	}
	static Service service = Factory.getServiceInstance();
	static SurveyDetails surveyDetails = Factory.getSurveyDetailsInstance();
	static SurveyorBean surveyor = Factory.getSurveyorBeanInstance();
	static final Logger logger = Logger.getLogger(SurveyorController.class);
	static Scanner sc = new Scanner(System.in);

	static List<SurveyorBean> surveyorList = new ArrayList<SurveyorBean>();
	static List<SurveyDetails> surveyDetailsList = new ArrayList<SurveyDetails>();

	public static void surveyorLogin() {
	
		FileReader reader1;
		try {
			reader1 = new FileReader("db.properties");
			Properties p = new Properties();
			try {
				p.load(reader1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		logger.info("Enter username: ");
		String surveyorUsername;
		surveyorUsername = sc.next();
		while (!service.usernameValidation(surveyorUsername)) {
			logger.info("Please Enter Valid  username ");
			surveyorUsername = sc.next();
		}
		logger.info("Enter password: ");
		String surveyorPassword;
		surveyorPassword = sc.next();
		while (!service.passwordValidation(surveyorPassword)) {
			logger.info("Please Enter Valid  password ");
			surveyorPassword = sc.next();
		}
		try {
			boolean value2=service.surveyorLoginService(surveyorUsername, surveyorPassword);
			if(value2) {
				logger.info("Surveyor Login Successful");
				insideSurveyorLogin();
			}else {
				throw new SurveyorNotFoundException();
			}
		}catch(SurveyorNotFoundException e) {
			logger.info("Login Failed!");
			logger.info("Please enter Valid UserName or Password!!");
			surveyorLogin();
		}
	}

	public static void insideSurveyorLogin() {

		boolean flag=true;
		do {
			logger.info("Please select any one of the following options:");
			logger.info("1.Create survey");
			logger.info("2.Update survey");
			logger.info("3.Delete survey");
			logger.info("4.View survey");
			logger.info("5.view AllSurveys");
			logger.info("6.Exit");
			String option = sc.next();
			while (!service.choiceValidation(option)) {
				logger.info("please enter valid choice: Accepts only [1-6]");
				option = sc.next();
			}
			int select = Integer.parseInt(option);

			switch (select) {

			case 1:
				logger.info("Add Survey");
				createSurvey();
				break;
			case 2:
				logger.info("Update Survey");
				updateSurvey();
				break;
			case 3:
				logger.info("Delete Survey");
				deleteSurvey();
				break;
			case 4:
				logger.info("View Survey");
				viewSurvey();
				break;
			case 5:
				logger.info("view All Surveys");
				viewAllSurveys();
				break;
			case 6:
				flag=false;
				logger.info("Logged Out Successfully");
				MainController.main(null);
				break;
			default:
				flag=!flag;
				logger.info("Enter valid choice");
				break;
			}
		} while (!flag);
	}

	public static boolean createSurvey() {
		SurveyDetails surveyDetails = Factory.getSurveyDetailsInstance();
		logger.info("Enter SurveyId:");
		String surveyId = sc.next();
		while (!service.idValidation(surveyId)) {
			logger.info("Enter valid ID: Accepts only [0-9]min: 1 and max: 10");
			surveyId = sc.next();
		}
		surveyDetails.setSurveyId(surveyId);

		logger.info("Enter SurveyTitle:");
		String surveyTitle = sc.next();
		while (!service.titleValidation(surveyTitle)) {
			logger.info("Enter valid Title: Accepts only [a-z][A-Z][.]space,min: 1 and max: 100");
			surveyTitle = sc.next();
		}
		surveyDetails.setSurveyTitle(surveyTitle);

		logger.info("Enter SurveyDescription:");
		sc.nextLine();
		String surveyDescription = sc.nextLine();
		while (!service.descriptionValidation(surveyDescription)) {
			logger.info("Enter valid Description: Accepts only [a-z][A-Z][.*]space,min: 1 and max: 200");
			surveyDescription = sc.nextLine();
		}

		surveyDetails.setSurveyDescription(surveyDescription);

		logger.info("Enter Question1 :");
		String question1 = sc.nextLine();

		while (!service.questionValidation(question1)) {
			logger.info("Enter valid question1: Accepts only [a-z][A-Z][.*?] min: 1 and max:100");
			question1 = sc.nextLine();
		}

		logger.info("Enter q1option1 :");
		String q1Option1 = sc.nextLine();
		while (!service.answerValidation(q1Option1)) {
			logger.info("Enter valid q1option1: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
			q1Option1 = sc.nextLine();
		}

		logger.info("Enter q1option2 :");
		String q1Option2 = sc.nextLine();
		while (!service.answerValidation(q1Option2)) {
			logger.info("Enter valid q1option2: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
			q1Option2 = sc.nextLine();
		}

		logger.info("Enter q1option3 :");
		String q1Option3 = sc.nextLine();
		while (!service.answerValidation(q1Option3)) {
			logger.info("Enter valid q1option3: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
			q1Option3 = sc.nextLine();
		}

		logger.info("Enter q1option4 :");
		String q1Option4 = sc.nextLine();
		while (!service.answerValidation(q1Option4)) {
			logger.info("Enter valid q1option4: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
			q1Option4 = sc.nextLine();
		}

		surveyDetails.setQuestion1(question1);
		surveyDetails.setQ1Option1(q1Option1);
		surveyDetails.setQ1Option2(q1Option2);
		surveyDetails.setQ1Option3(q1Option3);
		surveyDetails.setQ1Option4(q1Option4);

		logger.info("Enter Question2:");
		String question2 = sc.nextLine();
		while (!service.questionValidation(question2)) {
			logger.info("Enter valid question2: Accepts only [a-z][A-Z][.*?] min: 1 and max:100");
			question2 = sc.nextLine();
		}
		surveyDetails.setQuestion2(question2);

		logger.info("Enter q2option1 :");
		String q2Option1 = sc.nextLine();
		while (!service.answerValidation(q2Option1)) {
			logger.info("Enter valid q2option1: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
			q2Option1 = sc.nextLine();
		}
		surveyDetails.setQ2Option1(q2Option1);

		logger.info("Enter q2option2 :");
		String q2Option2 = sc.nextLine();
		while (!service.answerValidation(q2Option2)) {
			logger.info("Enter valid q2option2: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
			q2Option2 = sc.nextLine();
		}
		surveyDetails.setQ2Option2(q2Option2);

		logger.info("Enter q2option3 :");
		String q2Option3 = sc.nextLine();
		while (!service.answerValidation(q2Option3)) {
			logger.info("Enter valid q2option3:Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
			q2Option3 = sc.nextLine();
		}
		surveyDetails.setQ2Option3(q2Option3);

		logger.info("Enter q2option4 :");
		String q2Option4 = sc.nextLine();
		while (!service.answerValidation(q2Option4)) {
			logger.info("Enter valid q2option4: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
			q2Option4 = sc.nextLine();
		}
		surveyDetails.setQ2Option4(q2Option4);

		logger.info("Enter Question3 :");
		String question3 = sc.nextLine();
		while (!service.questionValidation(question3)) {
			logger.info("Enter valid question3:Accepts only [a-z][A-Z][.*?] min: 1 and max:100");
			question3 = sc.nextLine();
		}
		surveyDetails.setQuestion3(question3);

		logger.info("Enter Question4 :");
		String question4 = sc.nextLine();
		while (!service.questionValidation(question4)) {
			logger.info("Enter valid question4:Accepts only [a-z][A-Z][.*?] min: 1 and max:100");
			question4 = sc.nextLine();
		}
		surveyDetails.setQuestion4(question4);

		logger.info("Enter Question5 :");
		String question5 = sc.nextLine();
		while (!service.questionValidation(question5)) {
			logger.info("Enter valid question5: Accepts only [a-z][A-Z][.*?] min: 1 and max:100");
			question5 = sc.nextLine();
		}
		surveyDetails.setQuestion5(question5);
		surveyDetailsList.add(surveyDetails);
			boolean add = service.createSurveyService(surveyDetails);
			if (add) {
				logger.info("survey added sucessfully\n");
				insideSurveyorLogin();
			} else {
				logger.info("survey not added");
			}
		return true;
	}

	public static void updateSurvey() {
		logger.info("please enter the survey id to update");
		logger.info("Enter SurveyId:");
		String surveyId = sc.next();
		while (!service.idValidation(surveyId)) {
			logger.info("Please enter valid Id: which must be between [0-9] and min 1 and max 10");
			surveyId = sc.next();
		}
		boolean update = service.updateSurveyService(surveyId);
		if (update == true) {
			logger.info("Request Done");
			SurveyDetails surveyDetails = Factory.getDaoInstance().getSurvey(surveyId);
			logger.info("update surveytitle :");
			sc.nextLine();
			String surveyTitle = sc.nextLine();
			while (!service.titleValidation(surveyTitle)) {
				logger.error("Enter valid title: Accepts only [a-z][A-Z][.]space,min: 1 and max: 100");
				surveyTitle = sc.nextLine();
			}
			surveyDetails.setSurveyTitle(surveyTitle);

			logger.info("update surveydescription :");
			String surveyDescription = sc.nextLine();
			while (!service.descriptionValidation(surveyDescription)) {
				logger.info("Enter valid description: Accepts only [a-z][A-Z][.*]space,min: 1 and max: 200");
				surveyDescription = sc.nextLine();
			}
			surveyDetails.setSurveyDescription(surveyDescription);

			logger.info("Update question 1:");
			String question1 = sc.nextLine();
			while (!service.questionValidation(question1)) {
				logger.info("Enter valid question1:Accepts only [a-z][A-Z][.*?] min: 1 and max:100");
				question1 = sc.nextLine();
			}
			surveyDetails.setQuestion1(question1);

			logger.info("update question1 option1:");
			String q1Option1 = sc.nextLine();
			while (!service.answerValidation(q1Option1)) {
				logger.info("Enter valid q1option1: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
				q1Option1 = sc.nextLine();
			}
			surveyDetails.setQ1Option1(q1Option1);

			logger.info("update question1 option2:");
			String q1Option2 = sc.nextLine();
			while (!service.answerValidation(q1Option2)) {
				logger.info("Enter valid q1option2: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
				q1Option2 = sc.nextLine();
			}
			surveyDetails.setQ1Option2(q1Option2);

			logger.info("update question1 option3:");
			String q1Option3 = sc.nextLine();
			while (!service.answerValidation(q1Option3)) {
				logger.info("Enter valid q2option3: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
				q1Option3 = sc.nextLine();
			}
			surveyDetails.setQ1Option3(q1Option3);

			logger.info("update question1 option4:");
			String q1Option4 = sc.nextLine();
			while (!service.answerValidation(q1Option4)) {
				logger.info("Enter valid q1option4: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
				q1Option4 = sc.nextLine();
			}
			surveyDetails.setQ1Option4(q1Option4);

			logger.info("Update question 2:");
			String question2 = sc.nextLine();
			while (!service.questionValidation(question2)) {
				logger.info("Enter valid question2: Accepts only [a-z][A-Z][.*?] min: 1 and max:100");
				question2 = sc.nextLine();
			}
			surveyDetails.setQuestion2(question2);

			logger.info("update question2 option1:");
			String q2Option1 = sc.nextLine();
			while (!service.answerValidation(q2Option1)) {
				logger.info("Enter valid q2option1: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
				q2Option1 = sc.nextLine();
			}
			surveyDetails.setQ2Option1(q2Option1);

			logger.info("update question2 option2:");
			String q2Option2 = sc.nextLine();
			while (!service.answerValidation(q2Option2)) {
				logger.info("Enter valid q2option2: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
				q2Option2 = sc.nextLine();
			}
			surveyDetails.setQ2Option2(q2Option2);

			logger.info("update question2 option3: ");
			String q2Option3 = sc.nextLine();
			while (!service.answerValidation(q2Option3)) {
				logger.info("Enter valid q2option3: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
				q2Option3 = sc.nextLine();
			}
			surveyDetails.setQ2Option3(q2Option3);

			logger.info("update question2 option4: ");
			String q2Option4 = sc.nextLine();
			while (!service.answerValidation(q2Option4)) {
				logger.info("Enter valid q2option4: Accepts only[a-z][A-Z][0-9]space[.]min: 1 and max: 100");
				q2Option4 = sc.nextLine();
			}
			surveyDetails.setQ2Option4(q2Option4);

			logger.info("Update question 3:");
			String question3 = sc.nextLine();
			while (!service.questionValidation(question3)) {
				logger.info("Enter valid question3: Accepts only [a-z][A-Z][.*?] min: 1 and max:100");
				question3 = sc.nextLine();
			}
			surveyDetails.setQuestion3(question3);

			logger.info("Update question 4:");
			String question4 = sc.nextLine();
			while (!service.questionValidation(question4)) {
				logger.info("Enter valid question4: Accepts only [a-z][A-Z][.*?] min: 1 and max:100");
				question4 = sc.nextLine();
			}
			surveyDetails.setQuestion4(question4);

			logger.info("Update question 5:");
			String question5 = sc.nextLine();
			while (!service.questionValidation(question5)) {
				logger.info("Enter valid question5: Accepts only [a-z][A-Z][.*?] min: 1 and max:100");
				question5 = sc.nextLine();
			}
			surveyDetails.setQuestion5(question5);
		}
		logger.info(surveyDetailsList.add(surveyDetails));
	
		try {
			if (update == false) {
				throw new SurveyNotFoundException();
			} else {
				logger.info("Updated Successfully");
				insideSurveyorLogin();
			}
		} catch (SurveyNotFoundException e) {
			logger.error(e.getMessage());
			insideSurveyorLogin();
		}
	}

	public static void deleteSurvey() {
		sc.nextLine();
		logger.info("Enter a SurveyId:");
		String surveyId = sc.next();
		while (!service.idValidation(surveyId)) {
			logger.info("Enter valid Survey Id: which must be between [0-9] and min 1 and max 10\"");
			surveyId = sc.next();
		}

		boolean delete = service.deleteSurveyService(surveyId);

		try {
			if (delete == false) {
				throw new IdMisMatchException();
			} else {
				logger.info("deleted successfully");
				insideSurveyorLogin();
			}
		} catch (IdMisMatchException e) {
			logger.info("Survey Id not found");
			insideSurveyorLogin();
		}
	}

	public static List<SurveyDetails> viewSurvey() {
		Service service = Factory.getServiceInstance();
		logger.info("please enter the survey title to view:");
		sc.nextLine();
		String surveyTitle = sc.nextLine();
		while (!service.titleValidation(surveyTitle)) {
			logger.info("enter valid SurveyTitle: Accepts only [a-z][A-Z][.]space,min: 1 and max: 100");
			surveyTitle = sc.nextLine();
		}
		SurveyDetails surveyDetails =Factory.getServiceInstance().viewSurveyService(surveyTitle);
		try {
			if (surveyDetails!=null) {
				logger.info(surveyDetails);
				
			} else {
				throw new SurveyTitleNotFoundException();
			}
		} catch (SurveyTitleNotFoundException e) {
			logger.error(e.exceptionMessage());
			insideSurveyorLogin();
		}
		return surveyDetailsList;
	}

	public static List<SurveyDetails> viewAllSurveys() {
		SurveyDetails surveyDetails = Factory.getSurveyDetailsInstance();
		logger.info("Details of all Surveys !!");
		logger.info(service.viewAllSurveysService(surveyDetails));
		insideSurveyorLogin();
		return surveyDetailsList;

	}
}
