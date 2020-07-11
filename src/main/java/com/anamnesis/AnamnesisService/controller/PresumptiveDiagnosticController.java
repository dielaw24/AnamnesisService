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
import com.anamnesis.AnamnesisService.model.PresumptiveDiagnostic;
import com.anamnesis.AnamnesisService.repository.PresumptiveDiagnosticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/diagnostic")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PresumptiveDiagnosticController {

    @Autowired
    PresumptiveDiagnosticRepository presumptiveDiagnosticRepository;

    //Obtener todos los diagnosticos presuntivos
    @GetMapping
    public Iterable<PresumptiveDiagnostic> getAllDiagnostic(){
        return presumptiveDiagnosticRepository.findAll();
    }
    //Obtener  diagnosticos presuntivos por id
    @GetMapping("/{id_diag}")
    public PresumptiveDiagnostic getDiagnosticById(@PathVariable(value = "id_diag")Integer id){
        return presumptiveDiagnosticRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"PresumptiveDiagnostic dont found");
        });
    }
    //agregar  diagnosticos presuntivos
    @PostMapping
    public PresumptiveDiagnostic addDiagnostic(@RequestBody PresumptiveDiagnostic presumptiveDiagnostic){
        return presumptiveDiagnosticRepository.save(presumptiveDiagnostic);
    }

    //actualizar diagnosticos presuntivos
    @PutMapping
    public PresumptiveDiagnostic updateDiagnostic(@RequestBody PresumptiveDiagnostic presumptiveDiagnostic){
        return presumptiveDiagnosticRepository.save(presumptiveDiagnostic);
    }
    // eliminar diagnosticos presuntivos por id
    @DeleteMapping("/{id_diag}")
    public void deleteDiagnostic(@PathVariable(name = "id_diag")Integer id){
        if(presumptiveDiagnosticRepository.findById(id).isPresent()){
            presumptiveDiagnosticRepository.delete(presumptiveDiagnosticRepository.findById(id).get());
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"PresumptiveDiagnostic dont found");
        }
    }

}
