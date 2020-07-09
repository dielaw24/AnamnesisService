package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sintomas_Paciente")
public class PatientSymptom {
    @Id
    private int id_anamnesis;
    @Id
    @Column(name = "id_sintoma")
    private int id_symptom;

    public int getId_anamnesis() {
        return id_anamnesis;
    }

    public int getId_symptom() {
        return id_symptom;
    }

    public void setId_anamnesis(int id_anamnesis) {
        this.id_anamnesis = id_anamnesis;
    }

    public void setId_symptom(int id_symptom) {
        this.id_symptom = id_symptom;
    }


}
