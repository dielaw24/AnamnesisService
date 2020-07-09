package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "antecedentes_laborales")
public class Work_History {
    @Id
    @Column(name = "id_trabajo")
    private int id_work;
    @Id
    @Column(name = "id_anamnesis")
    private int id_anamnesis;
    @Column(name = "fecha_inicio_trabajo")
    private Date start_work_date;
    @Column(name = "fecha_fin_trabajo")
    private Date end_work_date;

    public int getId_work() {
        return id_work;
    }

    public int getId_anamnesis() {
        return id_anamnesis;
    }

    public Date getStart_work_date() {
        return start_work_date;
    }

    public Date getEnd_work_date() {
        return end_work_date;
    }

    public void setId_work(int id_work) {
        this.id_work = id_work;
    }

    public void setId_anamnesis(int id_anamnesis) {
        this.id_anamnesis = id_anamnesis;
    }

    public void setStart_work_date(Date start_work_date) {
        this.start_work_date = start_work_date;
    }

    public void setEnd_work_date(Date end_work_date) {
        this.end_work_date = end_work_date;
    }
}
