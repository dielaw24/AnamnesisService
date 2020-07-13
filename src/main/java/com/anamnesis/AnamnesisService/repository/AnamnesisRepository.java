package com.anamnesis.AnamnesisService.repository;

import com.anamnesis.AnamnesisService.model.Anamnesis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnamnesisRepository extends CrudRepository<Anamnesis,Integer> {
    @Query(value = "select * from anamnesis where id_paciente =:id", nativeQuery = true)
    List<Anamnesis> findByPatientId(@Param("id") Integer id);
}
