package com.anamnesis.AnamnesisService.controller;

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
