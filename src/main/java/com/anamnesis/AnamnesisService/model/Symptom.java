package com.anamnesis.AnamnesisService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Sintoma")
public class Symptom {
    @Id
    @Column(name = "id_sintoma")
    private String id_symptom;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "nombre_sintoma")
    private String symptom_name;

    //Relacion ManyToOne
    //Relacion con GrupoSintomas SymptomGroup
    @ManyToOne
    @JoinColumn(name = "id_grupo_sintoma")
    private SymptomGroup symptomGroup;

    //Relacion ManytoMany
    //Relacion sintomas paciente / clases Anamnesis y PatientSymptom
    /*@OneToMany(mappedBy = "symptom")
    private List<PatientSymptom> patientSymptomList;*/


    /*
    * Id_sintoma forma :R061, R062, ....
    * id grupo sintoma forma : R06
    *
    * */
    public String getId_symptom() {
        return id_symptom;
    }

    public String getDescription() {
        return description;
    }

    public String getSymptom_name() {
        return symptom_name;
    }

    public void setId_symptom(String id_symptom) {
        this.id_symptom = id_symptom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSymptom_name(String symptom_name) {
        this.symptom_name = symptom_name;
    }


    public SymptomGroup getSymptomGroup() {
        return symptomGroup;
    }

    public void setSymptomGroup(SymptomGroup symptomGroup) {
        this.symptomGroup = symptomGroup;
    }
}
