package manytomany;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Answer2 {
	
	@Id
	int aid;
	String answer;
	@ManyToMany
	List<QuestionM> que;
	
	public List<QuestionM> getQue() {
		return que;
	}
	public void setQue(List<QuestionM> que) {
		this.que = que;
	}
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
	
	

}
