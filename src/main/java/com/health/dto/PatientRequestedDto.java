package com.health.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class PatientRequestedDto implements Serializable {
	
	@Nullable
	private Integer pid;
	private String name;
	private String lastName;
	private String address;
	private Long mobile;
	@Nullable
	private LocalDate dt;
	
	public PatientRequestedDto(String name, String lastName, String address, Long mobile) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.mobile = mobile;
	}

}
