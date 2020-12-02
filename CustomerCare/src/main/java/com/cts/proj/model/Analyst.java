package com.cts.proj.model;

import java.time.LocalDateTime;


public class Analyst implements Comparable<Analyst>{
    private long analystId;
    private String password;
    private String tempPassword;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailId;
    private LocalDateTime dateOfBirth;
    private String gender;
    private String supportLevel;
    
    public Analyst() {
    	super();
    }
    
	public Analyst(long analystId, String password, String tempPassword, String firstName, String lastName,
			long phoneNumber, String emailId, LocalDateTime dateOfBirth, String gender, String supportLevel) {
		super();
		this.analystId = analystId;
		this.password = password;
		this.tempPassword = tempPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.supportLevel = supportLevel;
	}
	
	
	public long getAnalystId() {
		return analystId;
	}
	public void setAnalystId(long analystId) {
		this.analystId = analystId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTempPassword() {
		return tempPassword;
	}
	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSupportLevel() {
		return supportLevel;
	}
	public void setSupportLevel(String supportLevel) {
		this.supportLevel = supportLevel;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (analystId ^ (analystId >>> 32));
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
		result = prime * result + ((supportLevel == null) ? 0 : supportLevel.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Analyst other = (Analyst) obj;
		if (analystId != other.analystId)
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (supportLevel == null) {
			if (other.supportLevel != null)
				return false;
		} else if (!supportLevel.equals(other.supportLevel))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Analyst [analystId=" + analystId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", supportLevel=" + supportLevel + "]";
	}
	

	@Override
	public int compareTo(Analyst analystObj) {
		// TODO Auto-generated method stub
		if(this.analystId == analystObj.getAnalystId()) {
		return 0;
		}
		else if (this.analystId > analystObj.getAnalystId()) {
			return 1;
		}
		return -1;
	}
	
    
}
