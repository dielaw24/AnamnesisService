package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Anamnesis")
public class Anamnesis {
    @Id
    @Column(name = "id_anamnesis")
    private int id;
    @Column(name = "id_antecedente_p_patologico")
    private String id_pathological_history;
    @Column(name = "id_antecedente_np_patologico")
    private String id_no_pathological_history;
    @Column(name = "id_historial_clinico")
    private String id_clinical_history;
    @Column(name = "motivo_consulta")
    private String reason_consultation;
    @Column(name = "enfermedad_acutal")
    private String actual_disease;
    @Column(name = "id_examen_fisico")
    private String id_physical_test;
    @Column(name = "fecha_padecimiento")
    private String condition_Date;
    @Column(name = "id_condiciones_vivienda")
    private String id_housing_condition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_pathological_history() {
        return id_pathological_history;
    }

    public void setId_pathological_history(String id_pathological_history) {
        this.id_pathological_history = id_pathological_history;
    }

    public String getId_no_pathological_history() {
        return id_no_pathological_history;
    }

    public void setId_no_pathological_history(String id_no_pathological_history) {
        this.id_no_pathological_history = id_no_pathological_history;
    }

    public String getId_clinical_history() {
        return id_clinical_history;
    }

    public void setId_clinical_history(String id_clinical_history) {
        this.id_clinical_history = id_clinical_history;
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

    public String getId_physical_test() {
        return id_physical_test;
    }

    public void setId_physical_test(String id_physical_test) {
        this.id_physical_test = id_physical_test;
    }

    public String getCondition_Date() {
        return condition_Date;
    }

    public void setCondition_Date(String condition_Date) {
        this.condition_Date = condition_Date;
    }

    public String getId_housing_condition() {
        return id_housing_condition;
    }

    public void setId_housing_condition(String id_housing_condition) {
        this.id_housing_condition = id_housing_condition;
    }
}

