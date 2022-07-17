package com.health.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Parent;
import org.springframework.lang.Nullable;

import com.health.vo.ReportsVo;

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
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pid", referencedColumnName = "pid")
    private Patient pt;

	public Report(String infectionName2, String haemoglobin2, String platelets2, String liverFunctionTest2, Float inr2,
			LocalDate dt2) {
		super();
		this.infectionName = infectionName2;
		this.haemoglobin = haemoglobin2;
		this.platelets = platelets2;
		this.liverFunctionTest = liverFunctionTest2;
		this.inr = inr2;
		// TODO Auto-generated constructor stub
	}

	public Report(Integer pAge2, String infectionName2, String haemoglobin2, String platelets2,
			String liverFunctionTest2, Float inr2, LocalDate now) {
		// TODO Auto-generated constructor stub
		super();
		this.infectionName = infectionName2;
		this.haemoglobin = haemoglobin2;
		this.platelets = platelets2;
		this.liverFunctionTest = liverFunctionTest2;
		this.inr = inr2;
		this.pAge = pAge2;
		this.dt = now;
	}

	public Report(String infectionName2, String haemoglobin2, String platelets2, String liverFunctionTest2, Float inr2,
			LocalDate now, Patient patient) {
		// TODO Auto-generated constructor stub
		super();
		this.infectionName = infectionName2;
		this.haemoglobin = haemoglobin2;
		this.platelets = platelets2;
		this.liverFunctionTest = liverFunctionTest2;
		this.inr = inr2;
		this.dt = now;
		this.pt = patient;

	}

}
