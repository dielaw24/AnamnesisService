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

}
