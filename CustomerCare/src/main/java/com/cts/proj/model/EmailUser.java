package com.cts.proj.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "email_user")
public class EmailUser implements Comparable<EmailUser> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "email_id")
	private long emailId;
	@Column(name = "sent_date")
	private Date sentDate;
	@Column(name = "received")
	private boolean hasReceived;
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
	private Admin admin;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;

	public EmailUser() {
		super();
	}

	public EmailUser(long emailId, Date sentDate, boolean hasReceived, String description) {
		super();
		this.emailId = emailId;
		this.sentDate = sentDate;
		this.hasReceived = hasReceived;
		this.description = description;
	}

	public long getEmailId() {
		return emailId;
	}

	public void setEmailId(long emailId) {
		this.emailId = emailId;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public boolean isHasReceived() {
		return hasReceived;
	}

	public void setHasReceived(boolean hasReceived) {
		this.hasReceived = hasReceived;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (emailId ^ (emailId >>> 32));
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
		EmailUser other = (EmailUser) obj;
		if (emailId != other.emailId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmailUser [emailId=" + emailId + ", sentDate=" + sentDate + ", hasReceived=" + hasReceived
				+ ", description="
				+ (description != null ? (description.length() > 10 ? description.substring(0, 10) : description)
						: description)
				+ "]";
	}

	@Override
	public int compareTo(EmailUser obj) {

		if (this.emailId == obj.getEmailId()) {
			return 0;
		} else if (this.emailId > obj.getEmailId()) {
			return 1;
		}
		return -1;
	}

}
