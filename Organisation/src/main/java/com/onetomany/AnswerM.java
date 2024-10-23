package com.onetomany;

import com.onetoone.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AnswerM {
	@Id
	int aid;
	String answer;
	@ManyToOne
	Question1 ques;
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question1 getQues() {
		return ques;
	}
	public void setQues(Question1 ques) {
		this.ques = ques;
	}

}
