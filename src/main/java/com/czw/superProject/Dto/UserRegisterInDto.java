package com.czw.superProject.Dto;

import java.io.Serializable;

public class UserRegisterInDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String email;
	
	private String nickname;
	
	private String password;
	
	private String password2;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
