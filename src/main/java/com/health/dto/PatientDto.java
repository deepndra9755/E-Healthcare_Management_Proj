package com.health.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
public class PatientDto implements Serializable {
	
	@Nullable
	private Integer pid;
	private String pName;
	private String lastName;
	private String address;
	private Long mobile;
	@Nullable
	private LocalDate dt;
	private List<ReportDto> list;
	
	public PatientDto(String pName, String lastName, String address, Long mobile, List<ReportDto> list) {
		this.pName = pName;
		this.lastName = lastName;
		this.address = address;
		this.mobile = mobile;
		this.list = list;
	}
	
	

}
