package com.cts.proj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "responses")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "response_id")
	private int responseId;
	@Column(name = "question_id")
	private int questionId;
	@Column(name = "complaint_complaint_id")
	private int complaintId;
	@Column(name = "answer")
	private String answer;
	
	
	public Feedback(int responseId, int questionId, int complaintId, String answer) {
		super();
		this.responseId = responseId;
		this.questionId = questionId;
		this.complaintId = complaintId;
		this.answer = answer;
	}
	
	public Feedback() {
		super();
	} 
	public int getResponseId() {
		return responseId;
	}
	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Feedback [responseId=" + responseId + ", questionId=" + questionId + ", complaintId=" + complaintId
				+ ", answer=" + answer + "]";
	}

}
