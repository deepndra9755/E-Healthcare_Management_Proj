package com.health.service;

import com.health.dto.PatientDto;
import com.health.dto.ReportDto;

public interface IPatientService {
	public PatientDto insertPatient(PatientDto obj)throws Exception;
	public void Exist(Integer id)throws Exception;
	public PatientDto findPatientById(Integer id)throws Exception;
	public PatientDto updatePatient(PatientDto dto,Integer pid)throws Exception;

	
}
