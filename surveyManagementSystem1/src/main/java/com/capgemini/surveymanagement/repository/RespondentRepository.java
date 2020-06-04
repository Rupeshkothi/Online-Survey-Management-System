package com.capgemini.surveymanagement.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.surveymanagement.bean.RespondentBean;
import com.capgemini.surveymanagement.factory.Factory;

public class RespondentRepository {
	public static List<RespondentBean> respondentRepList = new ArrayList<>();

	public List<RespondentBean> defaultRespondentLogin() {
		
		RespondentBean respondent = Factory.getRespondentBeanInstance();
		
		respondent.setRespondentUsername("respondent");
		respondent.setRespondentPassword("respondent");
		respondent.setRespondentMailId("respondent@gmail.com");
		respondent.setRespondentContactNumber("8978408575");
		respondentRepList.add(respondent);;
		return respondentRepList;
		}
}
