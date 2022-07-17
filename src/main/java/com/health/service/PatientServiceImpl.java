package com.health.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.bo.Patient;
import com.health.bo.Report;
import com.health.dao.IPatientRepo;
import com.health.dto.PatientDto;
import com.health.dto.ReportDto;
import com.health.service.Mapper.Mapper;
import com.health.service.exceptions.RecordModificationException;
import com.health.service.exceptions.RecordNotFoundException;
import com.health.service.exceptions.RecordNotInsertedException;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepo repo;

	@Override
	public PatientDto insertPatient(PatientDto obj) throws Exception {
		try {
			System.out.println("service-------------------"+obj);
			System.out.println("mapper ---------"+Mapper.toPatient(obj));
			Patient pt = repo.save(Mapper.toPatient(obj));
			if (pt != null) {
				return Mapper.getPatientDto(pt);
			}
			throw new RecordNotInsertedException("Record NOT Inserted");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RecordNotInsertedException("Record NOT Inserted");
		}

	}

	@Override
	public void Exist(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			boolean flag = false;
			flag = repo.existsById(id);
			if (flag == false)
				throw new RecordNotFoundException(id + "");

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	@Override
	public PatientDto findPatientById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			Optional<Patient> obj = repo.findById(id);
			if (obj.isPresent()) {
				//return Mapper.getPatientDto(obj.get());
			}
			throw new RecordNotFoundException(" " + id);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	@Override
	@Transient
	public PatientDto updatePatient(PatientDto dto, Integer pid) throws Exception {
		// TODO Auto-generated method stub
		try {
			Patient p1=null;
			Optional<Patient> patient= repo.findById(pid);
             if(patient.isPresent())
             { 
            	p1=patient.get(); 
             }
			p1.setPName(dto.getPName());
			p1.setList(Mapper.getReportList(dto.getList()));

			if (p1.getPid() == pid) {
				Patient p3 = repo.save(p1);
				if (p3 != null) {
					return Mapper.getPatientDto(p3);
				}
			}
			throw new RecordModificationException("pid" + pid);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	

}
