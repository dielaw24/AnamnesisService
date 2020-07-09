package com.anamnesis.AnamnesisService.model;

import javax.persistence.*;

@Entity
@Table(name="Condiciones_Vivienda")
public class Housing_conditions {
    @Id
    @Column(name = "id_condiciones_vivienda")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="tipo_vivienda")
    private String house_type;
    @Column(name="zona")
    private String zone;
    @Column(name="acceso_agua_potable")
    private Boolean water_access;
    @Column(name="alcantarillado")
    private String sewerage;
    @Column(name="fabricas_cercanas")
    private String nearby_factories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Boolean getWater_access() {
        return water_access;
    }

    public void setWater_access(Boolean water_access) {
        this.water_access = water_access;
    }

    public String getSewerage() {
        return sewerage;
    }

    public void setSewerage(String sewerage) {
        this.sewerage = sewerage;
    }

    public String getNearby_factories() {
        return nearby_factories;
    }

    public void setNearby_factories(String nearby_factories) {
        this.nearby_factories = nearby_factories;
    }
}
