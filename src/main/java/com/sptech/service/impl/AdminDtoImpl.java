package com.sptech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sptech.entities.Admin;
import com.sptech.models.AdminDao;
import com.sptech.repositories.AdminRepositories;
import com.sptech.service.AdminDto;

@Service
public class AdminDtoImpl implements AdminDto {

	@Autowired
	private AdminRepositories adminRepo;
	@Override
	public AdminDao login(String userName, String password) {
		AdminDao adminDao = null;
		Admin admin = adminRepo.findByUserNameAndPassword(userName, password);
		if(admin != null) {
			adminDao = new AdminDao();
			adminDao = map(admin);
		}
		return adminDao;
	}
	
	private AdminDao map(Admin admin) {
		AdminDao adminDao = new AdminDao();
		if(admin != null) {
			adminDao.setUserName(admin.getUserName());
		}
		return adminDao;
	}

	
}
