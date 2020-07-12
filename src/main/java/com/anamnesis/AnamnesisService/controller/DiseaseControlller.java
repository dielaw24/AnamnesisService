package com.anamnesis.AnamnesisService.controller;
/*
Autores:
    Moyano Juan
    Tapia Diego
Docente:
    Ing. Villie Morocho
Facultad de Ingenieria
Universidad de Cuenca

Este módulo fue desarrollado como parte de la materia Base de Datos II , periodo marzo-julio 2020

*/
import com.anamnesis.AnamnesisService.model.Disease;
import com.anamnesis.AnamnesisService.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/disease")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class DiseaseControlller {
    @Autowired
    DiseaseRepository diseaseRepository;

    // Obtener todas las enfermedades
    @GetMapping
    public Iterable<Disease> getAllDisease(){
        return  diseaseRepository.findAll();
    }

    // obtener una enfermedad por su id
    @GetMapping("/{id_disease}")
    public Disease getDiseasebyId(@PathVariable(value = "id_disease") String id){
        return diseaseRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Disease dont found");
        });
    }
    // agregar una enfermedad a la base de datos
    @PostMapping
    public Disease addDisease(@RequestBody Disease disease){
        return diseaseRepository.save(disease);
    }

    // actualizar una enfermedad
    @PutMapping
    public Disease updateDisease(@RequestBody Disease disease){
        return diseaseRepository.save(disease);
    }

    // eliminar una enfermedad por su id
    @DeleteMapping("/{id_disease}")
    public void deleteDisease(@PathVariable (value = "id_disease") String id){
        if(diseaseRepository.findById(id).isPresent()){
            diseaseRepository.delete(diseaseRepository.findById(id).get());
        } else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Disease dont found");
        }
    }


}
