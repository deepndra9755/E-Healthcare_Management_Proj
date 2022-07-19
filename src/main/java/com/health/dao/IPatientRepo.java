package com.health.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.health.bo.Patient;
import com.health.dto.PatientDto;
import com.health.dto.PatientRequestedDto;

public interface IPatientRepo extends JpaRepository<Patient, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE com.health.bo.Patient SET pName=:#{#patient.name}," + "lastName=:#{#patient.lastName},"
			+ "address=:#{#patient.address}," + "mobile=:#{#patient.mobile}" + " where pid=:pif")
	public void updatePatinet(@Param("patient") PatientRequestedDto patient, @Param("pif") Integer pid);

}
