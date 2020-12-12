package com.cts.proj.model;

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
@Table(name = "feedback_response")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_response_id")
	private long responseId;

	@Column(name = "question")
	private String question;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "complaint_complaint_id")
	private Complaint complaint;

	@Column(name = "answer")
	private String answer;

	public Feedback() {
		super();
	}

	public Feedback(int responseId, String question, Complaint complaint, String answer) {
		super();
		this.responseId = responseId;
		this.question = question;
		this.complaint = complaint;
		this.answer = answer;
	}

	public long getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (responseId ^ (responseId >>> 32));
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
		Feedback other = (Feedback) obj;
		if (responseId != other.responseId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Feedback [responseId=" + responseId + ", question=" + question + ", answer=" + answer + "]";
	}

}
