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
import com.anamnesis.AnamnesisService.model.*;
import com.anamnesis.AnamnesisService.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/anamnesis")
@CrossOrigin (origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AnamnesisController {

    @Autowired
    AnamnesisRepository anamnesisRepository;
    @Autowired
    PathologicalPersonalHistoryRepository pathologicalPersonalHistoryRepository;
    @Autowired
    NoPatPersonalHistoryRepository noPatPersonalHistoryRepository;
    @Autowired
    FamilyRepository familyRepository;
    @Autowired
    FamilyHistoryRepository familyHistoryRepository;
    @Autowired
    HousingConditionsRepository housingConditionsRepository;
    @Autowired
    WorkRepository workRepository;
    @Autowired
    WorkHistoryRepository workHistoryRepository;
    @Autowired
    SymptomRepository symptomRepository;
    @Autowired
    PatientSymptomRepository patientSymptomRepository;
    @Autowired
    DiseaseRepository diseaseRepository;
    @Autowired
    PresumptiveDiagnosticRepository presumptiveDiagnosticRepository;
    @Autowired
    RegistryAnamnesisRepository registryAnamnesisRepository;
    @GetMapping
    public Iterable<Anamnesis> getAllAnamnesis(){
        return anamnesisRepository.findAll();
    }

    @GetMapping ("/{id_anamnesis}")
    public Anamnesis getAnamnesisById(@PathVariable(value="id_anamnesis") Integer id) {
        return anamnesisRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anamnesis dont found");
        });
    }

    @GetMapping ("/{id_paciente}")
    public Anamnesis getAnamnesisByPateientId(@PathVariable(value="id_paciente") Integer id) {
        return anamnesisRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anamnesis dont found");
        });
    }


    @PostMapping
    public Anamnesis addAnamnesis(@RequestBody  Anamnesis anamnesis) {
        anamnesis.setPathological_personal_history(pathologicalPersonalHistoryRepository.save(anamnesis.getPathological_personal_history()));
        anamnesis.setNo_pathological_personal_history(noPatPersonalHistoryRepository.save(anamnesis.getNo_pathological_personal_history()));
        anamnesis.setHousing_conditions(housingConditionsRepository.save(anamnesis.getHousing_conditions()));
        Anamnesis savedAnamnesis=anamnesisRepository.save(anamnesis);
        //List<FamilyHistory> familiesHistories = new ArrayList<>();
        for (FamilyHistory familyHistory : anamnesis.getFamilyHistoryList()) {
            familyHistory.setFamily(familyRepository.save(familyHistory.getFamily()));
            familyHistory.setAnamnesis(savedAnamnesis);
            familyHistoryRepository.save(familyHistory);
        }

        for (WorkHistory workHistory : anamnesis.getWorkHistoryList()) {
            workHistory.setWork(workRepository.save(workHistory.getWork()));
            workHistory.setAnamnesis(savedAnamnesis);
            workHistoryRepository.save(workHistory);
        }
        for (PatientSymptom patientSymptom  : anamnesis.getPatientSymptomList()) {
            patientSymptom.setAnamnesis(savedAnamnesis);
            patientSymptomRepository.save(patientSymptom);
        }
        for (PresumptiveDiagnostic presumptiveDiagnostic  : anamnesis.getPresumptiveDiagnosticList()) {
            presumptiveDiagnostic.setAnamnesis(savedAnamnesis);
            presumptiveDiagnosticRepository.save(presumptiveDiagnostic);
        }
        for (RegistryAnamnesis registryAnamnesis  : anamnesis.getRegistryAnamneses()) {
            registryAnamnesis.setAnamnesis(savedAnamnesis);
            registryAnamnesisRepository.save(registryAnamnesis);
        }



        //List<FamilyHistory> familyHistories = new ArrayList<>();
//        for (FamilyHistory familyHistory : anamnesis.getFamilyHistoryList()) {
//            familyHistories.add(familyRepository.save(familyHistory));
//        }
//        anamnesis.setFamilyHistoryList(familyHistories);
        return savedAnamnesis;
    }

    @PutMapping
    public Anamnesis updateAnamnesis(@RequestBody Anamnesis anamnesis) {
        return anamnesisRepository.save(anamnesis);
    }

    @DeleteMapping("/{id_anamnesis}")
    public void deleteAnamnesis(@PathVariable (value="id_anamnesis") Integer id) {
        if(anamnesisRepository.findById(id).isPresent()) {
            anamnesisRepository.delete(anamnesisRepository.findById(id).get());

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anamnesis dont found");
        }
    }







}
