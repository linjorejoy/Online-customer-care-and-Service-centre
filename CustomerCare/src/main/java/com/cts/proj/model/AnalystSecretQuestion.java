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
@Table(name = "a_sq_questions")
public class AnalystSecretQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_sq_id")
	private long analystSqId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "analyst_id")
	private Analyst analyst;

	@Column(name = "answer")
	private String answer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id", referencedColumnName = "question_id")
	private SecretQuestions secretQuestions;

	public AnalystSecretQuestion() {
		super();
	}

	public AnalystSecretQuestion(long analystSqId, String answer, SecretQuestions secretQuestions) {
		super();
		this.analystSqId = analystSqId;
		this.answer = answer;
		this.secretQuestions = secretQuestions;
	}

	public long getAnalystSqId() {
		return analystSqId;
	}

	public void setAnalystSqId(long analystSqId) {
		this.analystSqId = analystSqId;
	}

	public Analyst getAnalyst() {
		return analyst;
	}

	public void setAnalyst(Analyst analyst) {
		this.analyst = analyst;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (analystSqId ^ (analystSqId >>> 32));
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
		AnalystSecretQuestion other = (AnalystSecretQuestion) obj;
		if (analystSqId != other.analystSqId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnalystSecretQuestion [analystSqId=" + analystSqId + ", answer=" + answer + ", secretQuestions="
				+ secretQuestions.getDescription() + "]";
	}

}
