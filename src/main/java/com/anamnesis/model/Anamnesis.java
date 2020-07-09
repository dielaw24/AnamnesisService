package com.anamnesis.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Anamnesis")
public class Anamnesis {
    @Id
    @Column(name = "id_anamnesis")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //Datos anamnesis
    @Column(name = "motivo_consulta")
    private String reason_consultation;
    @Column(name = "enfermedad_acutal")
    private String actual_disease;
    @Column(name = "fecha_padecimiento")
    private Date condition_Date;
    //claves foraneas No locales
    @Column(name = "id_examen_fisico")
    private int id_physical_exam;    // id lo obtenemos del microservicio de examen fisico
    @Column(name = "id_paciente")
    private int id_patient;  // id lo obtenemos del microservicio de historial clinico, id atencion o historial o paciente o todos
    //claves foraneas locales/ Relacion ManyToOne
    //antecedentes personales patologicos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_antecedente_p_patologico")
    private Pathological_personal_history pathological_personal_history;
    //antecedentes personales no patologicos
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "id_antecedente_p_no_patologico")
    private No_Pathological_personal_history no_pathological_personal_history;
    //condiciones vivienda
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "id_condiciones_vivienda")
    private Housing_conditions housing_conditions;

    //Relaciones ManyToMany
    //Relacion antecedentes familiares / clase Family
    @ManyToMany
    @JoinTable(
            name = "Antecedentes_Familiares",
            joinColumns = @JoinColumn(name = "id_anamnesis"),
            inverseJoinColumns = @JoinColumn(name = "id_familiar")
    )
    private List<Family> familyList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pathological_personal_history getPathological_personal_history() {
        return pathological_personal_history;
    }

    public void setPathological_personal_history(Pathological_personal_history pathological_personal_history) {
        this.pathological_personal_history = pathological_personal_history;
    }

    public Date getCondition_Date() {
        return condition_Date;
    }

    public void setCondition_Date(Date condition_Date) {
        this.condition_Date = condition_Date;
    }

    public int getId_physical_exam() {
        return id_physical_exam;
    }

    public void setId_physical_exam(int id_physical_exam) {
        this.id_physical_exam = id_physical_exam;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public No_Pathological_personal_history getNo_pathological_personal_history() {
        return no_pathological_personal_history;
    }

    public void setNo_pathological_personal_history(No_Pathological_personal_history no_pathological_personal_history) {
        this.no_pathological_personal_history = no_pathological_personal_history;
    }

    public Housing_conditions getHousing_conditions() {
        return housing_conditions;
    }

    public void setHousing_conditions(Housing_conditions housing_conditions) {
        this.housing_conditions = housing_conditions;
    }

    public String getReason_consultation() {
        return reason_consultation;
    }

    public void setReason_consultation(String reason_consultation) {
        this.reason_consultation = reason_consultation;
    }

    public String getActual_disease() {
        return actual_disease;
    }

    public void setActual_disease(String actual_disease) {
        this.actual_disease = actual_disease;
    }

    public List<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<Family> familyList) {
        this.familyList = familyList;
    }
}

