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
import com.anamnesis.AnamnesisService.model.PathologicalPersonalHistory;
import com.anamnesis.AnamnesisService.repository.PathologicalPersonalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/patpersonalhistory")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PathologicalPersonalHistoryController {
    @Autowired
    PathologicalPersonalHistoryRepository pathologicalPersonalHistoryRepository;
    // obtener todos los antecedetes patologicos personales
    @GetMapping
    public Iterable<PathologicalPersonalHistory> getAllPathologicalPersonalHistory(){
        return pathologicalPersonalHistoryRepository.findAll();
    }
    // obtener antecedetes patologicos personales por id
    @GetMapping("/{id_pat_personal_hist}")
    public PathologicalPersonalHistory getPatPersonalHistoryById(@PathVariable(value = "id_pat_personal_hist") Integer id){
        return pathologicalPersonalHistoryRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"PathologicalPersonalHistory dont found");
        });
    }
    // agregar antecedetes patologicos personales
    @PostMapping
    public PathologicalPersonalHistory addPatPersonalHistory(@RequestBody PathologicalPersonalHistory pathologicalPersonalHistory){
        return pathologicalPersonalHistoryRepository.save(pathologicalPersonalHistory);
    }
    // actualizar antecedetes patologicos personales
    @PutMapping
    public PathologicalPersonalHistory updatePatPersonalHistory(@RequestBody PathologicalPersonalHistory pathologicalPersonalHistory){
        return pathologicalPersonalHistoryRepository.save(pathologicalPersonalHistory);
    }
    // eliminar antecedetes patologicos personales por id
    @DeleteMapping("/{id_pat_personal_hist}")
    public void deletePatPersonalHistory(@PathVariable(name = "id_pat_personal_hist") Integer id){
        if(pathologicalPersonalHistoryRepository.findById(id).isPresent()){
            pathologicalPersonalHistoryRepository.delete(pathologicalPersonalHistoryRepository.findById(id).get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"PathologicalPersonalHistory dont found");
        }
    }
}
