package com.health.controller.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.health.bo.Report;
import com.health.dto.PatientDto;
import com.health.dto.PatientRequestedDto;
import com.health.dto.ReportDto;
import com.health.vo.PatientRequestVo;
import com.health.vo.PatientVo;
import com.health.vo.ReportsVo;

public class Mapper {
	public static PatientDto toPatientDto(PatientVo obj) {
		List<ReportsVo> ob = obj.getList();
		List<ReportDto> list = new ArrayList<ReportDto>();
		for (ReportsVo o : ob) {
			list.add(new ReportDto(o.getInfectionName(), o.getHaemoglobin(), o.getPlatelets(), o.getLiverFunctionTest(),
					o.getInr()));
		}
		return new PatientDto(obj.getName(), obj.getLastName(), obj.getAddress(), obj.getMobile(), list);
	}

	public static PatientVo toPatientVo(PatientDto obj) {
		List<ReportDto> ob = obj.getList();
		List<ReportsVo> list = new ArrayList<ReportsVo>();
		for (ReportDto o : ob) {

			list.add(new ReportsVo(o.getPAge(), o.getInfectionName(), o.getHaemoglobin(), o.getPlatelets(),
					o.getLiverFunctionTest(), o.getInr(), o.getDt()));
		}
		return new PatientVo(obj.getPid(), obj.getPName(), obj.getLastName(), obj.getAddress(), obj.getMobile(),
				obj.getDt(), list);
	}

	public static ReportsVo getReport(ReportDto obj) {
		return new ReportsVo(obj.getPAge(), obj.getInfectionName(), obj.getHaemoglobin(), obj.getPlatelets(),
				obj.getLiverFunctionTest(), obj.getInr(), obj.getDt());
	}

	public static ReportDto getReport(ReportsVo obj) {
		return new ReportDto(obj.getInfectionName(), obj.getHaemoglobin(), obj.getPlatelets(),
				obj.getLiverFunctionTest(), obj.getInr());
	}

	public static PatientRequestedDto toPatientRequestedDto(PatientRequestVo vo) {
		return new PatientRequestedDto(vo.getName(), vo.getLastName(), vo.getAddress(), vo.getMobile());
	}

}
