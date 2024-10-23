package com.orgnize;

import jakarta.persistence.*;

@Entity
public class Employee {
	@Id
	private Integer emp_id;
	
	@Column(length = 100)
	private String emp_name;
	
	private Double salary;

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	

}
