package com.anamnesis.AnamnesisService.repository;

import com.anamnesis.AnamnesisService.model.Disease;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DiseaseRepository extends CrudRepository<Disease, String> {
    @Query(value = "select * from enfermedad limit 8", nativeQuery = true)
    List<Disease> findAll();

    @Query(value = "select * from enfermedad where enfermedad LIKE CONCAT('%',UPPER(:nombre),'%')", nativeQuery = true)
    List<Disease> findByDiseaseName(@Param("nombre") String nombre);
}
