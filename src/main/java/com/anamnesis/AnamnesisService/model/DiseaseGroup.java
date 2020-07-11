package com.anamnesis.AnamnesisService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Grupo_Enfermedad")
public class DiseaseGroup {
    @Id
    @Column(name = "id_grupo_enfermedad")
    private String id_disease_group;
    @Column(name = "grupo_enfermedad")
    private String disease_group;

    public  String getId_disease_group() {
        return id_disease_group;
    }

    public String getDisease_group() {
        return disease_group;
    }

    public void setId_disease_group(String id_disease_group) {
        this.id_disease_group = id_disease_group;
    }

    public void setDisease_group(String disease_group) {
        this.disease_group = disease_group;
    }
}
