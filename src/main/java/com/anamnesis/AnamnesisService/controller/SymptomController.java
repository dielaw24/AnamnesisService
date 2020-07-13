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
import com.anamnesis.AnamnesisService.model.Symptom;
import com.anamnesis.AnamnesisService.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/symptoms")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class SymptomController {
    @Autowired
    SymptomRepository symptomRepository;
    // obtener todos los sintomas
    @GetMapping
    public Iterable<Symptom> getAllSymptoms(){
        return symptomRepository.findAll();
    }
    // obtener sintoma por id
    @GetMapping("/{id_symptom}")
    public Symptom getSymptomById(@PathVariable(value = "id_symptom") String id){
        return symptomRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Symptom dont found");
        });
    }

    // buscar sintoma por nombre
    @GetMapping("/search/{symptom_name}")
    public Iterable<Symptom> getSymptomByName(@PathVariable(value = "symptom_name") String name){
        return symptomRepository.findBySymptomName(name);
    }
    // agregar sintoma
    @PostMapping
    public Symptom addSymptom(@RequestBody Symptom symptom){
        return symptomRepository.save(symptom);
    }
    // actualizar sintoma
    @PutMapping
    public Symptom updateSymptom(@RequestBody Symptom symptom){
        return symptomRepository.save(symptom);
    }
    // eliminar sintoma por id
    @DeleteMapping("/{id_symptom}")
    public void deleteSymptom(@PathVariable(value = "id_symptom")String id){
        if(symptomRepository.findById(id).isPresent()){
            symptomRepository.delete(symptomRepository.findById(id).get());
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Family dont found");
        }
    }

}
