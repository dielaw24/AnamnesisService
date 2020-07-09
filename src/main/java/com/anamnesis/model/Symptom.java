package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sintoma")
public class Symptom {
    @Id
    @Column(name = "id_sintoma")
    private int id_symptom;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "nombre_sintoma")
    private String symptom_name;


    /*
    * Id_sintoma forma R061, R062, ....
    * id grupo sintoma R06
    *
    * */
    public int getId_symptom() {
        return id_symptom;
    }

    public String getDescription() {
        return description;
    }

    public String getSymptom_name() {
        return symptom_name;
    }

    public void setId_symptom(int id_symptom) {
        this.id_symptom = id_symptom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSymptom_name(String symptom_name) {
        this.symptom_name = symptom_name;
    }

}
