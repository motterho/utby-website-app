package com.utby.springboot.web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String userid, String password) {
		// utby, utby
		return userid.equalsIgnoreCase("utby")
				&& password.equalsIgnoreCase("utby");
	}

}
