package com.cts.proj.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private int responseId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id")
	private FeedbackQuestions feedBackQuestion;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complaint_id")
	private Complaint complaint;

	@Column(name = "answer")
	private String answer;

	public Feedback() {
		super();
	}

	public Feedback(int responseId, String answer, FeedbackQuestions feedBackQuestion) {
		super();
		this.responseId = responseId;
		this.answer = answer;
		this.feedBackQuestion = feedBackQuestion;
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

	public FeedbackQuestions getFeedBackQuestion() {
		return feedBackQuestion;
	}

	public void setFeedBackQuestionList(FeedbackQuestions feedBackQuestion) {
		this.feedBackQuestion = feedBackQuestion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + responseId;
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
		return "Feedback [responseId=" + responseId + ", feedBackQuestion=" + feedBackQuestion + ", complaint="
				+ complaint + ", answer=" + answer + "]";
	}



}
