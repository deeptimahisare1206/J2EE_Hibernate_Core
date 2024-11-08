package com.myhql;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Faculty {

	@Id
	private Integer roll;
	private String name;
	private Integer salary;
	
	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

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


}
