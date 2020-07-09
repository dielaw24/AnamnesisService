package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Antecedentes_Personales_No_Patologicos")
public class No_Pathological_personal_history {
    @Id
    @Column(name = "id_antecedentes_personales_NP")
    private int id;
    @Column(name="actividad_fisica")
    private String physic_activities;
    @Column(name="habitos_toxicos")
    private String toxic_habits;
    @Column(name="alimentacion")
    private String alimentation;
    @Column(name="habito_suenio")
    private String dream_habits;
    @Column(name="ultima_donacion_sangre")
    private String last_blood_donation;
    @Column(name="automedicacion")
    private String automedication;
    @Column(name="higiene")
    private String hygiene;
    @Column(name="vacunas")
    private String vaccines;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhysic_activities() {
        return physic_activities;
    }

    public void setPhysic_activities(String physic_activities) {
        this.physic_activities = physic_activities;
    }

    public String getToxic_habits() {
        return toxic_habits;
    }

    public void setToxic_habits(String toxic_habits) {
        this.toxic_habits = toxic_habits;
    }

    public String getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(String alimentation) {
        this.alimentation = alimentation;
    }

    public String getDream_habits() {
        return dream_habits;
    }

    public void setDream_habits(String dream_habits) {
        this.dream_habits = dream_habits;
    }

    public String getLast_blood_donation() {
        return last_blood_donation;
    }

    public void setLast_blood_donation(String last_blood_donation) {
        this.last_blood_donation = last_blood_donation;
    }

    public String getAutomedication() {
        return automedication;
    }

    public void setAutomedication(String automedication) {
        this.automedication = automedication;
    }

    public String getHygiene() {
        return hygiene;
    }

    public void setHygiene(String hygiene) {
        this.hygiene = hygiene;
    }

    public String getVaccines() {
        return vaccines;
    }

    public void setVaccines(String vaccines) {
        this.vaccines = vaccines;
    }
}
