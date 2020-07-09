package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Diagnostico_Presuntivo")
public class PresumptiveDiagnostic {
    @Id
    @Column(name = "id_diagnostico_presuntivo")
    private int id_diagnostic;
    @Column(name = "diagnostico_presuntivo")
    private String presumptive_diagnostic;
    @Column(name = "id_anamnesis")
    private int id_anamnesis;
    @Column(name = "id_enfermedad")
    private int id_disease;

    public int getId_diagnostic() {
        return id_diagnostic;
    }

    public String getPresumptive_diagnostic() {
        return presumptive_diagnostic;
    }

    public int getId_anamnesis() {
        return id_anamnesis;
    }

    public int getId_disease() {
        return id_disease;
    }

    public void setId_diagnostic(int id_diagnostic) {
        this.id_diagnostic = id_diagnostic;
    }

    public void setPresumptive_diagnostic(String presumptive_diagnostic) {
        this.presumptive_diagnostic = presumptive_diagnostic;
    }

    public void setId_anamnesis(int id_anamnesis) {
        this.id_anamnesis = id_anamnesis;
    }

    public void setId_disease(int id_disease) {
        this.id_disease = id_disease;
    }
}
