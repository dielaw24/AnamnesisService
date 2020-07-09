package com.anamnesis.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Antecedentes_Laborales")
public class Work_History {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "fecha_inicio_trabajo")
    private Date start_work_date;
    @Column(name = "fecha_fin_trabajo")
    private Date end_work_date;
    //Relacion ManytoMany / clases Anamnesis y Work
    //Relacion antecedentes laborales
    @ManyToOne
    @JoinColumn(name = "id_anamnesis")
    private Anamnesis anamnesis;

    @ManyToOne
    @JoinColumn(name = "id_trabajo")
    private Work work;


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
