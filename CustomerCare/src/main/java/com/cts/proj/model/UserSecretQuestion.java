package com.cts.proj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "u_sq_questions")
public class UserSecretQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_sq_id")
	private long userSqId;
	@Column(name = "question_id")
	private long questionId;
	@Column(name = "user_id")
	private long userId;
	@Column(name = "answer")
	private String answer;

	public long getUserSqId() {
		return userSqId;
	}

	public void setUserSqId(long userSqId) {
		this.userSqId = userSqId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
