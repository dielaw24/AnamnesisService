package com.anamnesis.AnamnesisService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Sintomas_Paciente")
public class PatientSymptom {


    @Id
    @Column(name = "id_sintomas_paciente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_symptom_patient;

    // Relacion ManyToMany
    // Relacion sintomas paciente / clases anamnesis y symptom
    @ManyToOne
    @JoinColumn(name = "id_anamnesis")
    @JsonIgnore
    private Anamnesis anamnesis;

    @ManyToOne
    @JoinColumn(name = "id_sintoma")
    private Symptom symptom;

    public int getId_symptom_patient() {
        return id_symptom_patient;
    }

    public void setId_symptom_patient(int id_symptom_patient) {
        this.id_symptom_patient = id_symptom_patient;
    }

    public Anamnesis getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(Anamnesis anamnesis) {
        this.anamnesis = anamnesis;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

}
