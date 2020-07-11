package com.anamnesis.AnamnesisService.repository;

import com.anamnesis.AnamnesisService.model.Disease;
import org.springframework.data.repository.CrudRepository;

public interface DiseaseRepository extends CrudRepository <Disease, String> {

}
