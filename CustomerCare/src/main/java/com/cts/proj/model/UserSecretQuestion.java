package com.cts.proj.model;

public class UserSecretQuestion {

	private long userSqId;
	private long questionId;
	private long userId;
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
