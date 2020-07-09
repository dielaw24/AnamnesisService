package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Antecedentes_Personales_Patologicos")
public class Pathological_personal_history {
    @Id
    @Column(name = "id_antecedentes_personales_P")
    private int id;
    @Column(name="quirurgicos")
    private String quirurgicos;
    @Column(name="traumaticos")
    private String traumaticos;
    @Column(name="clinicos")
    private String clinicos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuirurgicos() {
        return quirurgicos;
    }

    public void setQuirurgicos(String quirurgicos) {
        this.quirurgicos = quirurgicos;
    }

    public String getTraumaticos() {
        return traumaticos;
    }

    public void setTraumaticos(String traumaticos) {
        this.traumaticos = traumaticos;
    }

    public String getClinicos() {
        return clinicos;
    }

    public void setClinicos(String clinicos) {
        this.clinicos = clinicos;
    }
}

