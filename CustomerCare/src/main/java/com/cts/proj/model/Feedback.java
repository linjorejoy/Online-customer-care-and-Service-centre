package com.cts.proj.model;

public class Feedback {
	private int responseId;
	private int questionId;
	private int complaintId;
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
