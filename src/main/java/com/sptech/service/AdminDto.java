package com.sptech.service;

import com.sptech.models.AdminDao;

public interface AdminDto {

	public AdminDao login(String userName, String password);
}
