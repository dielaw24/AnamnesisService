package com.anamnesis.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Enfermedad")
public class Disease {
    @Id
    @Column(name = "id_enfermedad")
    private int id_disease;
    @Column(name = "enfermedad")
    private String disease;

    //Relacion ManytoMany
    //Relacion Diagnostico Presuntivo / clases Anamnesis y PresumptiveDiagnostic
    @OneToMany(mappedBy = "disease")
    private List<PresumptiveDiagnostic> presumptiveDiagnosticList;

    public int getId_disease() {
        return id_disease;
    }

    public String getDisease() {
        return disease;
    }

    public void setId_disease(int id_disease) {
        this.id_disease = id_disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public List<PresumptiveDiagnostic> getPresumptiveDiagnosticList() {
        return presumptiveDiagnosticList;
    }

    public void setPresumptiveDiagnosticList(List<PresumptiveDiagnostic> presumptiveDiagnosticList) {
        this.presumptiveDiagnosticList = presumptiveDiagnosticList;
    }
}
