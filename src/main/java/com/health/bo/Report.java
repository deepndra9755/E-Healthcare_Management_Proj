package com.health.bo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Report implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pAge;
	private String infectionName;
	private String haemoglobin;
	private String platelets;
	private String liverFunctionTest;
	private Float inr;
	private LocalDate dt;

	public Report(String infectionName2, String haemoglobin2, String platelets2, String liverFunctionTest2, Float inr2,
			LocalDate dt2) {
		super();
		this.infectionName = infectionName2;
		this.haemoglobin = haemoglobin2;
		this.platelets = platelets2;
		this.liverFunctionTest = liverFunctionTest2;
		this.inr = inr2;
		this.dt=dt2;
		// TODO Auto-generated constructor stub
	}


}
