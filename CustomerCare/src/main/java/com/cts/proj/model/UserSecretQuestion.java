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

	@Column(name = "answer")
	private String answer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id")
	private SecretQuestions secretQuestions;
	
	
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


}
