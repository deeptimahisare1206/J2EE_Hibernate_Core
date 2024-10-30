package com.mypackage;

import jakarta.persistence.*;
import jakarta.persistence.Id;


@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Student_RollNo")
	private Integer roll;
	
	@Column(name="Student_Name" ,length = 100)
	private String name;
	@Column(name="Student_Percent")
	private Double percent;
	
	
	public Integer getRoll() {
		return roll;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	
	
	

}
