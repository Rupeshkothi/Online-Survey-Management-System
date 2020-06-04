package com.capgemini.surveymanagement.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.surveymanagement.bean.AdminBean;
import com.capgemini.surveymanagement.factory.Factory;

public class AdminRepository {
	public static List<AdminBean> adminRepList = new ArrayList<>();

	public List<AdminBean> defaultAdminLogin() {
		AdminBean adminBean = Factory.getAdminBeanInstance();
		adminBean.setAdminUsername("admin");
		adminBean.setAdminPassword("admin");
		adminRepList.add(adminBean);
		return adminRepList;
	}

}
