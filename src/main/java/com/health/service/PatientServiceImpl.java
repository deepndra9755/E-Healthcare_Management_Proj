package com.health.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.bo.Patient;
import com.health.bo.Report;
import com.health.dao.IPatientRepo;
import com.health.dto.PatientDto;
import com.health.dto.PatientRequestedDto;
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
				return Mapper.getPatientDto(obj.get());
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
			Patient p1 = null;
			System.out.println("inside service-------------------" + dto);
			Optional<Patient> patient = repo.findById(pid);
			if (patient.isPresent()) {
				p1 = patient.get();
				BeanUtils.copyProperties(dto, p1);
				p1.setPid(pid);
				Patient p3 = repo.save(p1);
				return Mapper.getPatientDto(p3);
			}

			throw new RecordModificationException("pid" + pid);
		} catch (

		Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	public List<PatientDto> findAll() throws Exception {
		// TODO Auto-generated method stub
		try {
			List<Patient> obj = repo.findAll();
			List<PatientDto> list = new ArrayList<PatientDto>();
			for (Patient p : obj) {
				list.add(Mapper.getPatientDto(p));
			}
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	@Override
	@Transactional
	public PatientDto updatePatient(PatientRequestedDto obj, Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			repo.updatePatinet(obj, id);
			Optional<Patient> optional = repo.findById(id);
			if (optional.isPresent()) {
				Patient patient = optional.get();
				return Mapper.getPatientDto(patient);
			}
			throw new RecordNotFoundException("not found");
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

}
