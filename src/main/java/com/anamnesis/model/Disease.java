package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Disease {
    @Id
    @Column(name = "id_enfermedad")
    private int id_disease;
    @Column(name = "enfermedad")
    private int disease;

    public int getId_disease() {
        return id_disease;
    }

    public int getDisease() {
        return disease;
    }

    public void setId_disease(int id_disease) {
        this.id_disease = id_disease;
    }

    public void setDisease(int disease) {
        this.disease = disease;
    }
}
