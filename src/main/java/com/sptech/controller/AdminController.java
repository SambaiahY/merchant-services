package com.sptech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sptech.models.AdminDao;
import com.sptech.models.LoginResponse;
import com.sptech.service.AdminDto;
import com.sptech.utilities.Utilities;

@RestController
@RequestMapping(value="api")
public class AdminController {
	
	@Autowired
	private AdminDto adminDto;
	
	@CrossOrigin
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<LoginResponse> login(@RequestHeader(value="userName") String userName, @RequestHeader(value="password") String password){
		LoginResponse response = new LoginResponse();
		try {
			AdminDao login = adminDto.login(userName, password);
			if(login != null) {
				response.setAdmin(login); 
				response.setStatus("success");
				Utilities.saveToken(response);
			}else {
				response.setStatus("failure");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			response.setStatus("failed");
		}
		return new ResponseEntity<LoginResponse>(response,HttpStatus.OK);
	}
}
