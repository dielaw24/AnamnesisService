package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.WorkHistory;
import com.anamnesis.AnamnesisService.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

/*
* Esta clase muestra toda la anamnesis en general, antecedentes, diagnosticos, sintomas, registro anamnesis de un paciente
*
* */
@RestController
@RequestMapping("/api/summary")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AnamnesisSummaryController {
    /*@Autowired
    AnamnesisRepository anamnesisRepository;
    @Autowired
    NoPatPersonalHistoryRepository noPatPersonalHistoryRepository;
    @Autowired
    PathologicalPersonalHistoryRepository pathologicalPersonalHistoryRepository;
    @Autowired
    HousingConditionsRepository housingConditionsRepository;
    @Autowired
    FamilyHistoryRepository familyHistoryRepository;
    @Autowired
    PresumptiveDiagnosticRepository presumptiveDiagnosticRepository;
    @Autowired
    PatientSymptomRepository patientSymptomRepository;

    @GetMapping("/{id_paciente}")
    public void getSummaryAnamnesisById(){

    }*/


}

