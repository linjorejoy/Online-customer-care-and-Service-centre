package com.cts.proj.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "complaint")
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "complaint_id")
	private long complaintId;
	@Column(name = "complaint_user_id")
	private long complaintUserId;
	@Column(name = "complaint_analyst_id")
	private long assignedAnalystId;
	@Column(name = "category")
	private String category;
	@Column(name = "phone_number")
	private long phoneNumber;
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private String status;
	@Column(name = "date_of_complaint")
	private Date dateOfComplaint;
	@Column(name = "suggestions")
	private String suggestions;

	public Complaint() {
		super();
	}

	public Complaint(long complaintId, long complaintUserId, long assignedAnalystId, String analystId, long phoneNumber,
			String description, String status, Date dateOfComplaint, String suggestions) {
		super();
		this.complaintId = complaintId;
		this.complaintUserId = complaintUserId;
		this.assignedAnalystId = assignedAnalystId;
		this.category = analystId;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.status = status;
		this.dateOfComplaint = dateOfComplaint;
		this.suggestions = suggestions;
	}

	public long getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(long complaintId) {
		this.complaintId = complaintId;
	}

	public long getComplaintUserId() {
		return complaintUserId;
	}

	public void setComplaintUserId(long complaintUserId) {
		this.complaintUserId = complaintUserId;
	}

	public long getAssignedAnalystId() {
		return assignedAnalystId;
	}

	public void setAssignedAnalystId(long assignedAnalystId) {
		this.assignedAnalystId = assignedAnalystId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateOfComplaint() {
		return dateOfComplaint;
	}

	public void setDateOfComplaint(Date dateOfComplaint) {
		this.dateOfComplaint = dateOfComplaint;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
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
		Complaint other = (Complaint) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", complaintUserId=" + complaintUserId + ", assignedAnalystId="
				+ assignedAnalystId + ", analystId=" + category + ", phoneNumber=" + phoneNumber + ", description="
				+ description + ", status=" + status + ", dateOfComplaint=" + dateOfComplaint + ", suggestions="
				+ suggestions + "]";
	}

}
