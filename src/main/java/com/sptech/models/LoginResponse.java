package com.sptech.models;

public class LoginResponse {

	private String status;
	private String token;
	private AdminDao admin;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public AdminDao getAdmin() {
		return admin;
	}
	public void setAdmin(AdminDao admin) {
		this.admin = admin;
	}
	
	
}
