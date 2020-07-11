package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.PatientSymptom;
import com.anamnesis.AnamnesisService.repository.PatientSymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/patientsymptom")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PatientSymptomController {

    @Autowired
    PatientSymptomRepository patientSymptomRepository;
    // obtener todos los sintomas de los pacientes
    @GetMapping
    public Iterable<PatientSymptom> getAllPatientSymptoms(){
        return patientSymptomRepository.findAll();
    }
    //obterner los sintomas del paciente por id
    @GetMapping("/{id_patient_symptom}")
    public PatientSymptom getPatientSymptomById(@PathVariable(name = "id_patient_symptom") Integer id){
        return patientSymptomRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"PatientSymptom dont found");
        });
    }

    // agregar sintomas del paciente
    @PostMapping
    public PatientSymptom addPatientSymptom(@RequestBody PatientSymptom patientSymptom) {
        return patientSymptomRepository.save(patientSymptom);
    }
    //actualizar sintomas del paciente
    @PutMapping
    public PatientSymptom updatePatientSymptom(@RequestBody PatientSymptom patientSymptom){
        return patientSymptomRepository.save(patientSymptom);
    }
    // eliminar sintomas del paciente por id
    @DeleteMapping("/{id_patient_symptom}")
    public void deletePatientSymptom(@PathVariable(name = "id_patient_symptom") Integer id){
        if(patientSymptomRepository.findById(id).isPresent()){
            patientSymptomRepository.delete(patientSymptomRepository.findById(id).get());
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"PatientSymptom dont found");
        }
    }
}
