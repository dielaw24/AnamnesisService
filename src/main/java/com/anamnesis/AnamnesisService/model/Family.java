package com.anamnesis.AnamnesisService.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="Familiar")
public class Family {
    @Id
    @Column(name = "id_familiar")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="cedula")
    private String cedula;
    @Column(name="nombre_completo")
    private String full_name;
    @Column(name="enfermedad")
    private String disease;
    @Column(name="relacion")
    private String relationship;
    @Column(name = "fuente")
    private String source;

    //Relacion ManytoMany
    // relacion antecedentes familiares / clase Anamnesis
    /*@OneToMany(mappedBy = "family")
    private List<FamilyHistory> familyHistoryList;*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    /*public List<FamilyHistory> getFamilyHistoryList() {
        return familyHistoryList;
    }

    public void setFamilyHistoryList(List<FamilyHistory> familyHistoryList) {
        this.familyHistoryList = familyHistoryList;
    }*/
}
