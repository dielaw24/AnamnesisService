package com.anamnesis.AnamnesisService.repository;

import com.anamnesis.AnamnesisService.model.Symptom;
import org.springframework.data.repository.CrudRepository;

public interface SymptomRepository extends CrudRepository<Symptom,String> {
}
