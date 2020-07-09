package com.anamnesis.model;

import javax.persistence.*;

@Entity
@Table(name = "Sintomas_Paciente")
public class PatientSymptom {


    @Id
    @Column(name = "id_sintomas_paciente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_symptom_patient;





}
