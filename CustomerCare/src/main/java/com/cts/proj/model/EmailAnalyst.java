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
@Table(name = "email_analyst")
public class EmailAnalyst {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "email_id")
	private long emailId;
	@Column(name = "sent_date")
	private Date sentDate;
	@Column(name = "received")
	private boolean received;
	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "analyst_id")
	private Analyst analyst;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	private Admin admin;

	public EmailAnalyst() {
		super();
	}

	public EmailAnalyst(long emailId, Date sentDate, boolean received, String description) {
		super();
		this.emailId = emailId;
		this.sentDate = sentDate;
		this.received = received;
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

	public boolean isReceived() {
		return received;
	}

	public void setReceived(boolean received) {
		this.received = received;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Analyst getAnalyst() {
		return analyst;
	}

	public void setAnalyst(Analyst analyst) {
		this.analyst = analyst;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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
		EmailAnalyst other = (EmailAnalyst) obj;
		if (emailId != other.emailId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmailAnalyst [emailId=" + emailId + ", sentDate=" + sentDate + ", received=" + received
				+ ", description=" + description + "]";
	}

}
