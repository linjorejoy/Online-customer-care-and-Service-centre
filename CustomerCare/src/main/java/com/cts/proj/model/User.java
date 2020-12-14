package com.cts.proj.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Comparable<User> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
	@Column(name = "password")
	private String password;
	@Column(name = "temp_password")
	private String tempPassword;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "phone_number")
	private long phoneNumber;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	@Column(name = "gender")
	private String gender;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "complaint_user_id")
	private List<Complaint> complaintList;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private List<EmailUser> emailList;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private List<UserSecretQuestion> secretQuestionList;

	public User() {
		super();
	}

	public User(long userId, String password, String tempPassword, String firstName, String lastName, long phoneNumber,
			String emailId, Date dateOfBirth, String gender) {
		super();
		this.userId = userId;
		this.password = password;
		this.tempPassword = tempPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public User(long userId, String password, String tempPassword, String firstName, String lastName, long phoneNumber,
			String emailId, Date dateOfBirth, String gender, List<Complaint> complaintList) {
		super();
		this.userId = userId;
		this.password = password;
		this.tempPassword = tempPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.complaintList = complaintList;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Complaint> getComplaintList() {
		return complaintList;
	}

	public void setComplaintList(List<Complaint> complaintList) {
		this.complaintList = complaintList;
	}

	public List<EmailUser> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<EmailUser> emailList) {
		this.emailList = emailList;
	}

	public List<UserSecretQuestion> getSecretQuestionList() {
		return secretQuestionList;
	}

	public void setSecretQuestionList(List<UserSecretQuestion> secretQuestionList) {
		this.secretQuestionList = secretQuestionList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public int compareTo(User userObj) {
		if (this.userId == userObj.getUserId()) {
			return 0;
		} else if (this.userId > userObj.getUserId()) {
			return 1;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", tempPassword=" + tempPassword + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", secretQuestionList=" + secretQuestionList
				+ "]";
	}



}
