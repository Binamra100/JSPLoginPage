package com.binamra100.JSPExample.Services;

import java.util.HashMap;

import com.binamra100.JSPExample.dbo.User;

public class LoginService {

	HashMap<String, String> users = new HashMap<String,String>();
	
	public LoginService(){
		users.put("bkandel","Binamra Kandel");
		users.put("sshrestha", "Shweta Shrestha");
		users.put("brkandel", "Balaram Kandel");
		users.put("nekandel","Neeta Kandel");
		users.put("nikandel", "Nitesh Kandel");
	}
	public boolean authentication(String userName, String passWord){
		if(passWord ==null || passWord.trim() ==""){
			return false;
		}
		return true;
	}
	
	public User getUserDetail(String username){
		User user = new User();
		user.setUsername(users.get(username));
		user.setUserID(username);
		return user;
		
	}
}
