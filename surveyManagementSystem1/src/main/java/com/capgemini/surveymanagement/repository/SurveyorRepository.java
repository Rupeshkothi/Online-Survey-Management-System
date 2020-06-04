package com.capgemini.surveymanagement.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.surveymanagement.bean.SurveyorBean;
import com.capgemini.surveymanagement.factory.Factory;

public class SurveyorRepository {
	public static List<SurveyorBean> surveyorList = new ArrayList<>();

	public List<SurveyorBean> defaultSurveyorLogin() {
		SurveyorBean surveyor = Factory.getSurveyorBeanInstance();
		surveyor.setSurveyorUsername("surveyor");
		surveyor.setSurveyorPassword("surveyor");
		surveyor.setSurveyorMailId("surveyor@gmail.com");
		surveyor.setSurveyorContactNumber("8978408575");
		surveyorList.add(surveyor);
		return surveyorList;
		}
}