package com.capgemini.surveymanagement.controller;

import java.util.Scanner;
 
import org.apache.log4j.Logger;

import com.capgemini.surveymanagement.factory.Factory;
import com.capgemini.surveymanagement.service.Service;

public class MainController {
	static final Logger logger = Logger.getLogger(MainController.class);
	static Scanner scanner = new Scanner(System.in);
	static Service service = Factory.getServiceInstance();

	private MainController() {

	}

	public static void main(String[] args) {
		boolean flag = true;
		do {
			logger.info("choose your option");
			logger.info("1.Admin Login ");
			logger.info("2.Surveyor Login");
			logger.info("3.Respondent Login");
			String choice1 = scanner.next();
			while (!service.choiceValidation(choice1)) {
				logger.info(" Enter valid choice from [1-4]");
				choice1 = scanner.next();
			}
			int choice = Integer.parseInt(choice1);

			switch (choice) {
			case 1:
				AdminController.adminLogin();
				break;
			case 2:
				SurveyorController.surveyorLogin();
				break;
			case 3:
				RespondentController.respondentLogin();
				break;
			default:
				flag = !flag;
				logger.info("Please Enter valid choice");
				break;
			}
		} while (!flag);
		scanner.close();
	}
}