package com.anamnesis.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Antecedentes_Laborales")
public class Work_History {
    @Id
    @Column(name = "id")
    private int id;

    //Relacion ManytoMany / clases Anamnesis y Work
    //Relacion antecedentes laborales
    @ManyToMany
    @JoinColumn(name = "id_anamnesis")
    private Anamnesis anamnesis;

    @ManyToMany
    @JoinColumn(name = "id_trabajo")
    private Work work;

    private Date start_work_date;

    private Date end_work_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Anamnesis getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(Anamnesis anamnesis) {
        this.anamnesis = anamnesis;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Date getStart_work_date() {
        return start_work_date;
    }

    public void setStart_work_date(Date start_work_date) {
        this.start_work_date = start_work_date;
    }

    public Date getEnd_work_date() {
        return end_work_date;
    }

    public void setEnd_work_date(Date end_work_date) {
        this.end_work_date = end_work_date;
    }
}
