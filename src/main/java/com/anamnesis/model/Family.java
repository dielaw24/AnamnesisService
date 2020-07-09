package com.anamnesis.model;


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

    //Relacion ManytoMany
    // relacion antecedentes familiares / clase Anamnesis
    @ManyToMany(mappedBy = "familyList")
    private List<Anamnesis> anamneses;

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

    public List<Anamnesis> getAnamneses() {
        return anamneses;
    }

    public void setAnamneses(List<Anamnesis> anamneses) {
        this.anamneses = anamneses;
    }
}
