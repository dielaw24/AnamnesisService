package com.anamnesis.AnamnesisService.repository;

import com.anamnesis.AnamnesisService.model.PatientSymptom;
import org.springframework.data.repository.CrudRepository;

import javax.sql.rowset.CachedRowSet;

public interface PatientSymptomRepository extends CrudRepository<PatientSymptom, Integer> {
}
