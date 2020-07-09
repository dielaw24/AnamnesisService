package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sintoma")
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
}
