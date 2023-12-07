package com.jbk.entity;

public class Custinfo {

	private int id;
	private String username;
	private String password;
	private String confirmpass;
	private String email;
	private String fullname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpass() {
		return confirmpass;
	}

	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "Custinfo [id=" + id + ", username=" + username + ", password=" + password + ", confirmpass="
				+ confirmpass + ", email=" + email + ", fullname=" + fullname + "]";
	}

}
