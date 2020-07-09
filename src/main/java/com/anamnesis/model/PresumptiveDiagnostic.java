package com.anamnesis.model;

import javax.persistence.*;

@Entity
@Table(name = "Diagnostico_Presuntivo")
public class PresumptiveDiagnostic {
    @Id
    @Column(name = "id_diagnostico_presuntivo")
    private int id_diagnostic;
    @Column(name = "diagnostico")
    private String diagnostic;

    //Relacion ManytoMany
    //Relacion Diagnostico Presuntivo // clases Diesease y Anamnesis
    @ManyToOne
    @JoinColumn(name = "id_anamnesis")
    private Anamnesis anamnesis;

    @ManyToOne
    @JoinColumn(name = "id_enfermedad")
    private Disease disease;

    public int getId_diagnostic() {
        return id_diagnostic;
    }

    public void setId_diagnostic(int id_diagnostic) {
        this.id_diagnostic = id_diagnostic;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Anamnesis getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(Anamnesis anamnesis) {
        this.anamnesis = anamnesis;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}
