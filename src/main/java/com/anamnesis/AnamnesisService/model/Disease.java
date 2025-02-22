package com.anamnesis.AnamnesisService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Enfermedad")
public class Disease {
    @Id
    @Column(name = "id_enfermedad")
    private String id_disease;
    @Column(name = "enfermedad")
    private String disease;
    //Relacion manytoOne
    //Relacion Grupo Enfermedades
    @ManyToOne
    @JoinColumn(name = "id_grupo_enfermedad")
    private DiseaseGroup diseaseGroup;
    //Relacion ManytoMany
    //Relacion Diagnostico Presuntivo / clases Anamnesis y PresumptiveDiagnostic

    /*@OneToMany(mappedBy = "disease")
    @JsonIgnore
    private List<PresumptiveDiagnostic> presumptiveDiagnosticList*/

    public String getId_disease() {
        return id_disease;
    }

    public String getDisease() {
        return disease;
    }

    public void setId_disease(String id_disease) {
        this.id_disease = id_disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public DiseaseGroup getDiseaseGroup() {
        return diseaseGroup;
    }

    public void setDiseaseGroup(DiseaseGroup diseaseGroup) {
        this.diseaseGroup = diseaseGroup;
    }
}
