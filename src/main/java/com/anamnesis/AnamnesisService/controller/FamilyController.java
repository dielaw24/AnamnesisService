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

import com.anamnesis.AnamnesisService.model.Anamnesis;
import com.anamnesis.AnamnesisService.model.Family;
import com.anamnesis.AnamnesisService.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/family")
@CrossOrigin (origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class FamilyController {
    @Autowired
    FamilyRepository familyRepository;
    //obtener todos los familiares de los antecedente familiares
    @GetMapping
    public Iterable<Family> getAllFamily(){
        return familyRepository.findAll();
    }
    //obtener un familiar por id
    @GetMapping ("/{id_familiar}")
    public Family getFamilyById(@PathVariable(value="id_familiar") Integer id) {
        return familyRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Family dont found");
        });
    }
    //agregar un familar
    @PostMapping
    public Family addFamily(@RequestBody  Family family) {
        return familyRepository.save(family);
    }
    //actualizar familiar
    @PutMapping
    public Family updateFamily(@RequestBody Family family) {
        return familyRepository.save(family);
    }
    //eliminar familiar
    @DeleteMapping("/{id_familiar}")
    public void deleteFamily(@PathVariable (value="id_familiar") Integer id) {
        if(familyRepository.findById(id).isPresent()) {
            familyRepository.delete(familyRepository.findById(id).get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Family dont found");
        }
    }
}
