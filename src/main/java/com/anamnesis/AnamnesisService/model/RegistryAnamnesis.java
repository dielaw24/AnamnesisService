package com.anamnesis.AnamnesisService.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/*
* Se obtiene el id/datos del personal medico desde el microservicio de gestion de medicos
*
* */

@Entity
@Table(name = "Registro_Anamnesis")
public class RegistryAnamnesis {
    @Id
    @Column(name = "id_anamnesis")
    private int id_anamnesis;
    @Id
    @Column(name = "id_personal_medico")
    private int id_medical_staff;
    @Column (name = "fecha_anamnesis")
    private Date anamnesis_date;

    public int getId_anamnesis() {
        return id_anamnesis;
    }

    public int getId_medical() {
        return id_medical_staff;
    }

    public Date getAnamnesis_date() {
        return anamnesis_date;
    }

    public void setId_anamnesis(int id_anamnesis) {
        this.id_anamnesis = id_anamnesis;
    }

    public void setId_medical_staff(int id_medical_staff) {
        this.id_medical_staff = id_medical_staff;
    }

    public void setAnamnesis_date(Date anamnesis_date) {
        this.anamnesis_date = anamnesis_date;
    }
}
