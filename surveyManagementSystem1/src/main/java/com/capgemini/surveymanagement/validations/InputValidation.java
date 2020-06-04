package com.capgemini.surveymanagement.validations;

public interface InputValidation {

	public boolean usernameValidation(String username);

	public boolean passwordValidation(String password);

	public boolean idValidation(String id);

	public boolean answerValidation(String answer);

	public boolean choiceValidation(String choice);

	public boolean titleValidation(String title);

	public boolean questionValidation(String question);

	public boolean descriptionValidation(String description);

	public boolean contactValidation(String contact);
	
	public boolean mailIdValidation(String mailId);

	public boolean answerValidation1(String answer);
	
	public boolean answerValidation2(String answer);

}