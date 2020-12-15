package com.cts.proj.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "secret_questions")
public class SecretQuestions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private long questionId;
	@Column(name = "question_description")
	private String description;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "question_id")
	private List<UserSecretQuestion> userSecretQuestionList;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "question_id")
	private List<AnalystSecretQuestion> analystSecretQuestionList;

	public SecretQuestions() {
		super();
	}

	public SecretQuestions(long questionId, String description) {
		super();
		this.questionId = questionId;
		this.description = description;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserSecretQuestion> getUserSecretQuestionList() {
		return userSecretQuestionList;
	}

	public void setUserSecretQuestionList(List<UserSecretQuestion> userSecretQuestionList) {
		this.userSecretQuestionList = userSecretQuestionList;
	}

	public List<AnalystSecretQuestion> getAnalystSecretQuestionList() {
		return analystSecretQuestionList;
	}

	public void setAnalystSecretQuestionList(List<AnalystSecretQuestion> analystSecretQuestionList) {
		this.analystSecretQuestionList = analystSecretQuestionList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (questionId ^ (questionId >>> 32));
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
		SecretQuestions other = (SecretQuestions) obj;
		if (questionId != other.questionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SecretQuestions [questionId=" + questionId + ", description=" + description + "]";
	}

}
