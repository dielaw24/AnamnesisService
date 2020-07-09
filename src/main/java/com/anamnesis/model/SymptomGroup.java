package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo_Sintoma")
public class SymptomGroup {
    @Id
    @Column(name = "id_grupo_sintoma")
    private int id_symptom_group;
    @Column(name = "grupo_sintoma")
    private String symptom_group;

    public int getId_symptom_group() {
        return id_symptom_group;
    }

    public String getSymptom_group() {
        return symptom_group;
    }
}
