package com.model;

public class Registration {

	
	private String firstname;
	private String lastname;
	private long contact_no;
	private Login login;
	
	
	public Registration(Login login) {
		this.login = login;
	}


	public String getEmail() {
		return login.getEmail();
	}


	public void setEmail(String email) {
		login.setEmail(email);
	}


	public String getPassword() {
		return login.getPassword();
	}


	public void setPassword(String password) {
		login.setPassword(password);
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public long getContact_no() {
		return contact_no;
	}


	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	
	

	
	
	
	
	
}
