package com.cts.proj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback_question")
public class FeedBackQuestions implements Comparable<FeedBackQuestions> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private long feedbackQuestionId;
	@Column(name = "question_description")
	private String description;

	public long getFeedbackQuestionId() {
		return feedbackQuestionId;
	}

	public void setFeedbackQuestionId(long feedbackQuestionId) {
		this.feedbackQuestionId = feedbackQuestionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FeedBackQuestions(long feedbackQuestionId, String description) {
		super();
		this.feedbackQuestionId = feedbackQuestionId;
		this.description = description;
	}

	public FeedBackQuestions() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (feedbackQuestionId ^ (feedbackQuestionId >>> 32));
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
		FeedBackQuestions other = (FeedBackQuestions) obj;
		if (feedbackQuestionId != other.feedbackQuestionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeedbackQuestionTable [feedbackQuestionId=" + feedbackQuestionId + ", description=" + description + "]";
	}

	@Override
	public int compareTo(FeedBackQuestions o) {
		// TODO Auto-generated method stub

		if (this.feedbackQuestionId == o.getFeedbackQuestionId()) {
			return 0;
		} else if (this.feedbackQuestionId > o.getFeedbackQuestionId()) {
			return 1;
		}

		return -1;
	}

}
