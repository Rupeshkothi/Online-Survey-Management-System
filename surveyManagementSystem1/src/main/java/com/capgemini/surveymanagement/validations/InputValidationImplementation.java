package com.capgemini.surveymanagement.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidationImplementation implements InputValidation {
	Pattern pattern = null;
	Matcher matcher = null;

	public boolean usernameValidation(String username) {
		pattern = Pattern.compile("[a-zA-Z0-9]+[\\s[[a-zA-Z0-9]+]{2,20}]");
		matcher = pattern.matcher(username);
		return matcher.matches();

	}

	public boolean passwordValidation(String password) {
		pattern = Pattern.compile("[a-zA-Z0-9@!#$%^&*]+");
		matcher = pattern.matcher(password);
		return matcher.matches();
		
	}

	public boolean idValidation(String id) {
		pattern = Pattern.compile("[0-9]{1,100}");
		matcher = pattern.matcher(id);
		return matcher.matches();
	}

	public boolean answerValidation(String answer) {
		pattern = Pattern.compile("[a-zA-Z]+[\\s[[a-zA-Z]+]]*");               
		matcher = pattern.matcher(answer);
		return matcher.matches();

	}

	public boolean choiceValidation(String choice) {
		pattern = Pattern.compile("[0-9]{1,2}");
		matcher = pattern.matcher(choice);
		return matcher.matches();

	}

	public boolean titleValidation(String title) {
		pattern = Pattern.compile("[a-zA-Z]+[\\s[[a-zA-Z]+]]*");
		matcher = pattern.matcher(title);
		return matcher.matches();

	}

	public boolean questionValidation(String question) {
		pattern = Pattern.compile("[a-zA-Z.?*]+[\\s[[a-zA-Z]+]]{1,100}");
		matcher = pattern.matcher(question);
		return matcher.matches();
	}

	public boolean descriptionValidation(String description) {

		pattern = Pattern.compile("[a-zA-Z]+[\\s[[a-zA-Z]+]]{1,200}.*");
		matcher = pattern.matcher(description);
		return matcher.matches();

	}

	public boolean contactValidation(String contact) {
		pattern = Pattern.compile("[0-9]{10}");
		matcher = pattern.matcher(contact);
		return matcher.matches();

	}

	public boolean mailIdValidation(String mailId) {
		pattern = Pattern.compile(
				"^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,20}$");

		matcher = pattern.matcher(mailId);
		return matcher.matches();

	}
	
	public boolean answerValidation1(String answer) {
		pattern = Pattern.compile("[1-9]");               
		matcher = pattern.matcher(answer);
		return matcher.matches();

	}

	@Override
	public boolean answerValidation2(String answer) {
		pattern = Pattern.compile("^[a-zA-z ?]{10,30}");
		matcher = pattern.matcher(answer);
		return matcher.matches();
	}


}