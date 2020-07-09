package com.anamnesis.model;

import javax.persistence.*;

@Entity
@Table(name = "Antecedentes_Familiares")
public class FamilyHistory {

    @Id
    @Column(name = "id_antecedente_familiar")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_family_history;

    //Relacion ManyToMany
    //Relacion antecedentes familiares /clases family y anamnesis
    @ManyToOne
    @JoinColumn(name = "id_familiar")
    private Family family;
    @ManyToOne
    @JoinColumn(name = "id_anamnesis")
    private Anamnesis anamnesis;

    public int getId_family_history() {
        return id_family_history;
    }

    public void setId_family_history(int id_family_history) {
        this.id_family_history = id_family_history;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Anamnesis getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(Anamnesis anamnesis) {
        this.anamnesis = anamnesis;
    }
}
