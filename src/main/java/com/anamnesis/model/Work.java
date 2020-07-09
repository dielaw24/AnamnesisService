package com.anamnesis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Trabajo")
public class Work {
    @Id
    @Column(name = "id_trabajo")
    private int id;
    @Column(name="trabajo")
    private String work;
    @Column(name="descripcion_actividad")
    private String activity_description;

    public int getId() {  return id; }

    public void setId(int id) { this.id = id; }

    public String getWork() { return work; }

    public void setWork(String work) { this.work = work; }

    public void setActivity_description(String activity_description) { this.activity_description = activity_description; }

    public String getActivity_description() { return activity_description; }
    

}
