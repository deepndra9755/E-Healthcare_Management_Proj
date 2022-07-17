package com.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.controller.mapper.Mapper;
import com.health.dto.PatientDto;
import com.health.dto.ReportDto;
import com.health.service.IPatientService;
import com.health.vo.PatientVo;
import com.health.vo.ReportsVo;

@RestController
@RequestMapping("/api/v1")
public class PatientResource {
	@Autowired
	private IPatientService patientService;

	@PostMapping("/patient")
	public PatientVo insertPatient(@RequestBody PatientVo obj) throws Exception {
		PatientDto dto = Mapper.toPatientDto(obj);
		PatientDto ob = patientService.insertPatient(dto);
		PatientVo vo = Mapper.toPatientVo(ob);
		return vo;
	}

	@GetMapping("/patient/{pid}")
	public PatientVo findPatient(@PathVariable Integer pid) throws Exception {
		ThrowIfNot(pid);
		PatientDto dto = patientService.findPatientById(pid);

		return Mapper.toPatientVo(dto);
	}

	@PutMapping("/patient/{pid}")
	public PatientVo updatePatient(@RequestBody PatientVo vo, @PathVariable Integer pid) throws Exception {
		ThrowIfNot(pid);
		PatientDto vo1 = Mapper.toPatientDto(vo);
		PatientDto dto = patientService.updatePatient(vo1, pid);

		return Mapper.toPatientVo(dto);
	}

	
	
	/*
	 * @PatchMapping("/patient/{pid}/reports") public PatientVo
	 * updateReports(@RequestBody ReportsVo vo, @PathVariable Integer pid) throws
	 * Exception { ThrowIfNot(pid); ReportDto dto = Mapper.getReport(vo); PatientDto
	 * dt = patientService.updatePatient(dto, pid); return Mapper.toPatientVo(dt);
	 * 
	 * }
	 */

	public void ThrowIfNot(Integer id) throws Exception {
		try {
			patientService.Exist(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

}
