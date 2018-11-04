package com.sptech.utilities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sptech.models.LoginResponse;

@Component
public class Utilities {

	private static Map<String,Date> tokens = new HashMap<String, Date>();
	public static void saveToken(LoginResponse response) {
		Date date = new Date();
		tokens.put(date.getTime()+"", date);
		response.setToken(date.getTime()+"");
	}
}
