package com.health.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class ReportDto implements Serializable {
	private Integer pAge;
	private String infectionName;
	private String haemoglobin;
	private String platelets;
	private String liverFunctionTest;
	private Float inr;
	@Nullable
	private LocalDate dt;
	public ReportDto(String infectionName, String haemoglobin, String platelets, String liverFunctionTest, Float inr) {
		
		this.infectionName = infectionName;
		this.haemoglobin = haemoglobin;
		this.platelets = platelets;
		this.liverFunctionTest = liverFunctionTest;
		this.inr = inr;
	}
	
	

}
