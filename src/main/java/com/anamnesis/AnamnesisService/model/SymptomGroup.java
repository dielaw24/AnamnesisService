package com.anamnesis.AnamnesisService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo_Sintoma")
public class SymptomGroup {
    @Id
    @Column(name = "id_grupo_sintoma")
    private String id_symptom_group;
    @Column(name = "grupo_sintoma")
    private String symptom_group;

    public String getId_symptom_group() {
        return id_symptom_group;
    }

    public String getSymptom_group() {
        return symptom_group;
    }

    public void setId_symptom_group(String id_symptom_group) {
        this.id_symptom_group = id_symptom_group;
    }

    public void setSymptom_group(String symptom_group) {
        this.symptom_group = symptom_group;
    }
}
