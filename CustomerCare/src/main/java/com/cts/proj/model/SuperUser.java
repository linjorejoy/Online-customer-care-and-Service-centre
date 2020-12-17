package com.cts.proj.model;

public class SuperUser {

	private String registeredId;
	private String registeredPassword;

	public SuperUser() {
		super();
	}

	public SuperUser(String registeredId, String registeredPassword) {
		super();
		this.registeredId = registeredId;
		this.registeredPassword = registeredPassword;
	}

	public String getRegisteredId() {
		return registeredId;
	}

	public void setRegisteredId(String registeredId) {
		this.registeredId = registeredId;
	}

	public String getRegisteredPassword() {
		return registeredPassword;
	}

	public void setRegisteredPassword(String registeredPassword) {
		this.registeredPassword = registeredPassword;
	}

}
