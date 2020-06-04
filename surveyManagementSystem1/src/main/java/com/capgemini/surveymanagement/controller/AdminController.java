package com.capgemini.surveymanagement.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.capgemini.surveymanagement.bean.AdminBean;
import com.capgemini.surveymanagement.bean.RespondentBean;
import com.capgemini.surveymanagement.bean.SurveyDetails;
import com.capgemini.surveymanagement.bean.SurveyorBean;
import com.capgemini.surveymanagement.exception.SurveyorNotFoundException;
import com.capgemini.surveymanagement.factory.Factory;
import com.capgemini.surveymanagement.service.Service;

public class AdminController {
	static Service service = Factory.getServiceInstance();
	static AdminBean admin = Factory.getAdminBeanInstance();
	static SurveyDetails survey = Factory.getSurveyDetailsInstance();
	static RespondentBean respondent = Factory.getRespondentBeanInstance();
	static SurveyorBean surveyor = Factory.getSurveyorBeanInstance();
	static final Logger logger = Logger.getLogger(AdminController.class);
	static Scanner sc = new Scanner(System.in);
	static int count = 0;

	private AdminController() {

	}

	public static void adminLogin() {
		FileReader reader;
		try {
			reader = new FileReader("db.properties");
			Properties p = new Properties();
			try {
				p.load(reader);
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		} catch (FileNotFoundException e2) {
			logger.error(e2.getMessage());
		}

		logger.info("Enter username: ");
		String adminUsername;
		adminUsername = sc.next();
		while (!service.usernameValidation(adminUsername)) {
			logger.info("Please Enter Valid  username ");
			adminUsername = sc.next();
		}
		logger.info("Enter password: ");
		String adminPassword;
		adminPassword = sc.next();
		while (!service.passwordValidation(adminPassword)) {
			logger.info("Please Enter Valid  password ");
			adminPassword = sc.next();
		}

		try {
			boolean value2 = service.adminLoginService(adminUsername, adminPassword);
			if (value2) {
				logger.info("Admin Login Successful");
				afterAdminLogin();
			} else {
				throw new SurveyorNotFoundException();
			}
		} catch (SurveyorNotFoundException e) {
			logger.info("Login Failed!");
			logger.info("Please enter Valid UserName or Password!!");
			adminLogin();
		}

	}

	public static void afterAdminLogin() {
	 
		boolean flag=true;
		do {
			logger.info("Please select any of the following options ");
			logger.info("1.Add Surveyor");
			logger.info("2.Add Respondent");
			logger.info("3.Login as Surveyor");
			logger.info("4.Login as Respondent");
			logger.info("5.View all Surveyors");
			logger.info("6.View all Respondents");
			logger.info("7.Exit");
			String option = sc.next();
			while (!service.choiceValidation(option)) {
				logger.info("Please Enter valid choice ");
				option = sc.next();
			}
			int select = Integer.parseInt(option);

			switch (select) {

			case 1:
				logger.info("Add Surveyor");
				addSurveyor();
				break;
			case 2:
				logger.info("Add Respondent");
				addRespondent();
				break;
			case 3:
				logger.info("Surveyor Login");
				SurveyorController.surveyorLogin();
				break;
			case 4:
				logger.info("Respondent Login");
				RespondentController.respondentLogin();
				break;
			case 5:
				logger.info("All Surveyors");
				viewAllSurveyors();
				break;
			case 6:
				logger.info("All Respondents");
				viewAllRespondents();
				break;
			case 7:
				flag=false;
				logger.info("Logged Out Successfully");
				MainController.main(null);
				break;
			default:
				flag=!flag;
				logger.info("Enter a valid choice");
				break;
			}
		} while (!flag);

	}

	public static void addSurveyor() {
		SurveyorBean surveyor = Factory.getSurveyorBeanInstance();
		logger.info("Enter Surveyor Id :");
		String surveyorId = sc.next();
		while (!service.idValidation(surveyorId)) {
			logger.info("Enter a valid surveyorId:");
			surveyorId = sc.next();
		}
		surveyor.setSurveyorId(surveyorId);

		logger.info("Enter Surveyor Username:");
		String surveyorUsername = sc.next();
		while (!service.usernameValidation(surveyorUsername)) {
			logger.info("Enter a valid username: ");
			surveyorUsername = sc.next();
		}
		surveyor.setSurveyorUsername(surveyorUsername);

		logger.info("Enter  Surveyor password:");
		String surveyorPassword = sc.next();
		while (!service.passwordValidation(surveyorPassword)) {
			logger.info("Enter a valid password:");
			surveyorPassword = sc.next();
		}
		surveyor.setSurveyorPassword(surveyorPassword);

		logger.info("Enter mailId:");
		String mailId = sc.next();
		while (!service.mailIdValidation(mailId)) {
			logger.info("Enter valid mailid:");
			mailId = sc.next();
		}
		surveyor.setSurveyorMailId(mailId);

		logger.info("Enter Contact Number:");
		String contact = sc.next();
		while (!service.contactValidation(contact)) {
			logger.info("Enter valid contactNumber:");
			contact = sc.next();
		}
		surveyor.setSurveyorContactNumber(contact);

		boolean add = service.addSurveyorService(surveyor);
		if (add) {
			logger.info("Surveyor added sucessfully");
		} else {
			logger.info("Suveyor not added");
		}
	}

	public static void addRespondent() {
		RespondentBean respondent = Factory.getRespondentBeanInstance();
		logger.info("Enter Respondent Username:");

		String respondentUsername = sc.next();
		while (!service.usernameValidation(respondentUsername)) {
			logger.info("Enter a valid Respondent Username:");
			respondentUsername = sc.next();
		}
		respondent.setRespondentUsername(respondentUsername);

		logger.info("Enter Respondent Password:");
		String respondentPassword = sc.next();
		while (!service.passwordValidation(respondentPassword)) {
			logger.info("Enter a valid password:");
			respondentPassword = sc.next();
		}
		respondent.setRespondentPassword(respondentPassword);

		logger.info("Enter mailId:");
		String mailId = sc.next();
		while (!service.mailIdValidation(mailId)) {
			logger.info("Enter valid mailid:");
			mailId = sc.next();
		}
		respondent.setRespondentMailId(mailId);

		logger.info("Enter Contact Number: ");
		String phone = sc.next();
		while (!service.contactValidation(phone)) {
			logger.info("Enter valid number:");
			phone = sc.next();
		}
		respondent.setRespondentContactNumber(phone);

		boolean value1 = service.addRespondentService(respondent);
		if (value1) {
			logger.info("Respondent added sucessfully");
		} else {
			logger.info("Respondent not added");
		}
	}

	public static void viewAllSurveyors() {
		logger.info("Details of all Surveyors !!");
		logger.info(service.viewAllSurveyorsService(surveyor));
	}

	public static void viewAllRespondents() {
		logger.info("Details of all Respondents !!");
		logger.info(service.viewAllRespondentService(respondent));
	}
}
