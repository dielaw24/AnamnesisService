package com.anamnesis.AnamnesisService.model;


import javax.persistence.*;
import java.util.Date;

/*
* Se obtiene el id/datos del personal medico desde el microservicio de gestion de medicos
*
* */

@Entity
@Table(name = "Registro_Anamnesis")
public class RegistryAnamnesis {
    @Id
    @Column(name = "id_registro")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_register;
    //solo id de personal medico, se planea/ba comsumir de otro servicio
    @Column(name = "id_personal_medico")
    private int id_medical_staff;
    @Column (name = "fecha_anamnesis")
    private Date anamnesis_date;


    //Relacion ManytoMan
    //Relacion registro anamnesis
    @ManyToOne
    @JoinColumn(name = "id_anamneis")
    private Anamnesis anamnesis;

    public int getId_medical() {
        return id_medical_staff;
    }

    public Date getAnamnesis_date() {
        return anamnesis_date;
    }



    public void setId_medical_staff(int id_medical_staff) {
        this.id_medical_staff = id_medical_staff;
    }

    public void setAnamnesis_date(Date anamnesis_date) {
        this.anamnesis_date = anamnesis_date;
    }

    public int getId_register() {
        return id_register;
    }

    public void setId_register(int id_register) {
        this.id_register = id_register;
    }

    public int getId_medical_staff() {
        return id_medical_staff;
    }
}
