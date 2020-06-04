package com.capgemini.surveymanagement.bean;

import java.io.Serializable;
public class AdminBean implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminBean() {

	}

	private String adminUsername;
	private String adminPassword;

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "AdminBean [adminUsername=" + adminUsername + ", adminPassword=" + adminPassword + "]";
	}

}
