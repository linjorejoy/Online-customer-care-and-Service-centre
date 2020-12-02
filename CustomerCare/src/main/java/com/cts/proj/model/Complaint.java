package com.cts.proj.model;

import java.util.Date;

public class Complaint {
    
    long complaintId;
    long complaintUserId;
    long assignedAnalystId;
    String analystId;
    long phoneNumber;
    String description;
    String status;
    Date dateOfComplaint;
    String suggestions;
    
    
    public Complaint() {
        super();
    }
    public Complaint(long complaintId, long complaintUserId, long assignedAnalystId, String analystId, long phoneNumber,
            String description, String status, Date dateOfComplaint, String suggestions) {
        super();
        this.complaintId = complaintId;
        this.complaintUserId = complaintUserId;
        this.assignedAnalystId = assignedAnalystId;
        this.analystId = analystId;
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
    public String getAnalystId() {
        return analystId;
    }
    public void setAnalystId(String analystId) {
        this.analystId = analystId;
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
        result = prime * result + ((analystId == null) ? 0 : analystId.hashCode());
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
        if (analystId == null) {
            if (other.analystId != null)
                return false;
        } else if (!analystId.equals(other.analystId))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Complaint [complaintId=" + complaintId + ", complaintUserId=" + complaintUserId + ", assignedAnalystId="
                + assignedAnalystId + ", analystId=" + analystId + ", phoneNumber=" + phoneNumber + ", description="
                + description + ", status=" + status + ", dateOfComplaint=" + dateOfComplaint + ", suggestions="
                + suggestions + "]";
    }
    
    

}
