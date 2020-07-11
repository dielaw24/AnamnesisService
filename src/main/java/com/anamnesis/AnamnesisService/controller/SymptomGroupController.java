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

import com.anamnesis.AnamnesisService.model.SymptomGroup;
import com.anamnesis.AnamnesisService.repository.SymptomGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/symptomgroup")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class SymptomGroupController {
    @Autowired
    SymptomGroupRepository symptomGroupRepository;
    // obtener todos los sintomas
    @GetMapping
    public Iterable<SymptomGroup> getAllSymptomGrups(){
        return symptomGroupRepository.findAll();
    }
    // obtener grupo sintoma por id
    @GetMapping("/{id_symptom_group}")
    public SymptomGroup getSymptomById(@PathVariable(value = "id_symptom_group") String id){
        return symptomGroupRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"SymptomGroup dont found");
        });
    }
    // agregar grupo sintoma
    @PostMapping
    public SymptomGroup addSymptomGroup(@RequestBody SymptomGroup symptomGroup){
        return symptomGroupRepository.save(symptomGroup);
    }
    // actualizar grupo sintoma
    @PutMapping
    public SymptomGroup updateSymptom(@RequestBody SymptomGroup symptomGroup){
        return symptomGroupRepository.save(symptomGroup);
    }
    // eliminar grupo sintoma por id
    @DeleteMapping("/{id_symptom}")
    public void deleteSymptomGroup(@PathVariable(value = "id_symptom")String id){
        if(symptomGroupRepository.findById(id).isPresent()){
            symptomGroupRepository.delete(symptomGroupRepository.findById(id).get());
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"SymptomGrup dont found");
        }
    }
}
