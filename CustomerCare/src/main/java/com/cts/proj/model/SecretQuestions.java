package com.cts.proj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToOne(mappedBy = "secretQuestions")
	private UserSecretQuestion userSecretQuestion;

	@OneToOne(mappedBy = "secretQuestions")
	private AnalystSecretQuestion analystSecretQuestion;
	
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

    public UserSecretQuestion getUserSecretQuestion() {
		return userSecretQuestion;
	}

	public void setUserSecretQuestion(UserSecretQuestion userSecretQuestion) {
		this.userSecretQuestion = userSecretQuestion;
	}

	public AnalystSecretQuestion getAnalystSecretQuestion() {
		return analystSecretQuestion;
	}

	public void setAnalystSecretQuestion(AnalystSecretQuestion analystSecretQuestion) {
		this.analystSecretQuestion = analystSecretQuestion;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
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
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "SecretQuestions [questionId=" + questionId + ", description=" + description + "]";
	}
    
    

}
