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
@Table(name = "ANALYST")
public class Analyst implements Comparable<Analyst> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "analyst_id")
	private long analystId;
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
	@Column(name = "support_level")
	private String supportLevel;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "assigned_analyst_id")
	private List<Complaint> complaintList;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "analyst_id")
	private List<EmailAnalyst> emailList;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "analyst_id")
	private List<AnalystSecretQuestion> secretQuestionList;

	public Analyst() {
		super();
	}

	public Analyst(long analystId, String password, String tempPassword, String firstName, String lastName,
			long phoneNumber, String emailId, Date dateOfBirth, String gender, String supportLevel) {
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

	public String getSupportLevel() {
		return supportLevel;
	}

	public void setSupportLevel(String supportLevel) {
		this.supportLevel = supportLevel;
	}

	public List<Complaint> getComplaintList() {
		return complaintList;
	}

	public void setComplaintList(List<Complaint> complaintList) {
		this.complaintList = complaintList;
	}

	public List<EmailAnalyst> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<EmailAnalyst> emailList) {
		this.emailList = emailList;
	}

	public List<AnalystSecretQuestion> getSecretQuestionList() {
		return secretQuestionList;
	}

	public void setSecretQuestionList(List<AnalystSecretQuestion> secretQuestionList) {
		this.secretQuestionList = secretQuestionList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (analystId ^ (analystId >>> 32));
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
		return true;
	}

	@Override
	public String toString() {
		return "Analyst [analystId=" + analystId + ", password=" + password + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", supportLevel=" + supportLevel + "]";
	}

	@Override
	public int compareTo(Analyst analystObj) {
		// TODO Auto-generated method stub
		if (this.analystId == analystObj.getAnalystId()) {
			return 0;
		} else if (this.analystId > analystObj.getAnalystId()) {
			return 1;
		}
		return -1;
	}

}
