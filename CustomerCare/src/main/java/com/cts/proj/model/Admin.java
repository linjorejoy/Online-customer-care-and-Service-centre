package com.cts.proj.model;

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
@Table(name = "ADMIN")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private long adminId;
	@Column(name = "password")
	private String password;
	@Column(name = "temp_password")
	private String tempPassword;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email_id")
	private String emailId;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "admin_id")
	private List<EmailUser> emailListUser;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "admin_id")
	private List<EmailAnalyst> emailListAdmin;

	public Admin() {
		super();
	}

	public Admin(long adminId, String password, String tempPassword, String firstName, String lastName, String emailId,
			List<EmailUser> emailListUser, List<EmailAnalyst> emailListAdmin) {
		super();
		this.adminId = adminId;
		this.password = password;
		this.tempPassword = tempPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.emailListUser = emailListUser;
		this.emailListAdmin = emailListAdmin;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<EmailUser> getEmailListUser() {
		return emailListUser;
	}

	public void setEmailListUser(List<EmailUser> emailListUser) {
		this.emailListUser = emailListUser;
	}

	public List<EmailAnalyst> getEmailListAdmin() {
		return emailListAdmin;
	}

	public void setEmailListAdmin(List<EmailAnalyst> emailListAdmin) {
		this.emailListAdmin = emailListAdmin;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", password=" + password + ", tempPassword=" + tempPassword
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", emailListUser="
				+ emailListUser + ", emailListAdmin=" + emailListAdmin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (adminId ^ (adminId >>> 32));
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
		Admin other = (Admin) obj;
		if (adminId != other.adminId)
			return false;
		return true;
	}

}
