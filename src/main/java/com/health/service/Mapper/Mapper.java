package com.health.service.Mapper;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.BeanUtils;

import com.health.bo.Patient;
import com.health.bo.Report;
import com.health.dto.PatientDto;
import com.health.dto.ReportDto;

public class Mapper {

	public static Patient toPatient(PatientDto obj) {
		   
		return new Patient(obj.getPName(), obj.getLastName(), obj.getAddress(), obj.getMobile(), LocalDate.now(),
				getReportList(obj.getList()));

	}

	public static List<Report> getReportList(List<ReportDto> obj) {
		List<ReportDto> dto = obj;
		List<Report> ob = new ArrayList<Report>();
		for (ReportDto o : dto) {
			Report rp = new Report(o.getInfectionName(), o.getHaemoglobin(), o.getPlatelets(), o.getLiverFunctionTest(),
					o.getInr(), LocalDate.now());

			ob.add(rp);
		}
		return ob;
	}

	public static List<ReportDto> getReportDtoList(List<Report> obj) {
		List<Report> dto = obj;
		List<ReportDto> ob1 = new ArrayList<ReportDto>();
		for (Report o : dto) {
			ob1.add(new ReportDto(o.getPAge(), o.getInfectionName(), o.getHaemoglobin(), o.getPlatelets(),
					o.getLiverFunctionTest(), o.getInr(), o.getDt()));
		}
		return ob1;
	}

	public static PatientDto getPatientDto(Patient ob) {
		PatientDto pd = new PatientDto(ob.getPid(), ob.getPName(), ob.getLastName(), ob.getAddress(), ob.getMobile(),
				ob.getDt(), getReportDtoList(ob.getList()));
		return pd;
	}

	

	public static ReportDto getReport(Report obj) {
		return new ReportDto(obj.getPAge(), obj.getInfectionName(), obj.getHaemoglobin(), obj.getPlatelets(),
				obj.getLiverFunctionTest(), obj.getInr(), obj.getDt());
	}

}
