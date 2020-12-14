package com.cts.proj.model;

import java.util.List;

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
@Table(name = "u_sq_questions")
public class UserSecretQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_sq_id")
	private long userSqId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "answer")
	private String answer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id", referencedColumnName = "question_id")
	private SecretQuestions secretQuestions;
	
	
	public UserSecretQuestion() {
		super();
	}

	public UserSecretQuestion(long userSqId, String answer, SecretQuestions secretQuestions) {
		super();
		this.userSqId = userSqId;
		this.answer = answer;
		this.secretQuestions = secretQuestions;
	}

	public long getUserSqId() {
		return userSqId;
	}

	public void setUserSqId(long userSqId) {
		this.userSqId = userSqId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public SecretQuestions getSecretQuestions() {
		return secretQuestions;
	}

	public void setSecretQuestions(SecretQuestions secretQuestions) {
		this.secretQuestions = secretQuestions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userSqId ^ (userSqId >>> 32));
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
		UserSecretQuestion other = (UserSecretQuestion) obj;
		if (userSqId != other.userSqId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserSecretQuestion [userSqId=" + userSqId + ", user=" + user.getUserId() + ", secretQuestions=" + secretQuestions
				+ ", answer=" + answer + "]";
	}




}
