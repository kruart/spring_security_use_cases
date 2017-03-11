package com.oreilly.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {

		//BCryptPasswordEncoder is recommended
		BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();
		String encodedPassword1 = encoder1.encode("password");
		System.out.println(encodedPassword1);

		//how to equals raw and salted values
		System.out.println(encoder1.matches("password", encodedPassword1));


		//StandardPasswordEncoder
		StandardPasswordEncoder encoder2 = new StandardPasswordEncoder();
		String encodedPassword2 = encoder2.encode("password");
		System.out.println(encodedPassword2);


	}
}
