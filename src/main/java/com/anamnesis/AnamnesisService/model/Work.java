package com.anamnesis.AnamnesisService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Trabajo")
public class Work {
    @Id
    @Column(name = "id_trabajo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="trabajo")
    private String work;
    @Column(name="descripcion_actividad")
    private String activity_description;

    //Relacion ManytoMany
    //Relacion antecedentes laborales / clase Anamnesis y work_history
    /*@OneToMany(mappedBy = "work")
    private List<WorkHistory> work_histories;*/

    public int getId() {  return id; }

    public void setId(int id) { this.id = id; }

    public String getWork() { return work; }

    public void setWork(String work) { this.work = work; }

    public void setActivity_description(String activity_description) { this.activity_description = activity_description; }

    public String getActivity_description() { return activity_description; }

    /*public List<WorkHistory> getWork_histories() {
        return work_histories;
    }

    public void setWork_histories(List<WorkHistory> work_histories) {
        this.work_histories = work_histories;
    }*/
}
