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
@Table(name = "responses")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "response_id")
	private int responseId;
	@Column(name = "answer")
	private String answer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private FeedBackQuestions feedbackQuestionTable;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "complaint_complaint_id")
	private Complaint complaint;

	public Feedback() {
		super();
	}

	public Feedback(int responseId, String answer, FeedBackQuestions feedbackQuestionTable, Complaint complaint) {
		super();
		this.responseId = responseId;
		this.answer = answer;
		this.feedbackQuestionTable = feedbackQuestionTable;
		this.complaint = complaint;
	}

	public int getResponseId() {
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

	public FeedBackQuestions getFeedbackQuestionTable() {
		return feedbackQuestionTable;
	}

	public void setFeedbackQuestionTable(FeedBackQuestions feedbackQuestionTable) {
		this.feedbackQuestionTable = feedbackQuestionTable;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

}
