package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class DiseaseGroup {
    @Id
    @Column(name = "id_grupo_enfermedad")
    private int id_disease_group;
    @Column(name = "grupo_enfermedad")
    private String disease_group;

    public int getId_disease_group() {
        return id_disease_group;
    }

    public String getDisease_group() {
        return disease_group;
    }
}
