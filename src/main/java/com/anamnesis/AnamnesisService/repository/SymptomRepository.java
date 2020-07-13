package com.anamnesis.AnamnesisService.repository;

import com.anamnesis.AnamnesisService.model.Symptom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SymptomRepository extends CrudRepository<Symptom,String> {
    @Query(value = "select * from sintoma where nombre_sintoma LIKE CONCAT('%',UPPER(:nombre),'%')", nativeQuery = true)
    List<Symptom> findBySymptomName(@Param("nombre") String nombre);
}
