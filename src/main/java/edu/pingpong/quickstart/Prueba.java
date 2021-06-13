package edu.pingpong.quickstart;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "prueba")
public class Prueba extends PanacheEntity {
    @Column
    public String nombre;

    public Prueba(String nombre) {
        this.nombre = nombre;
    }

    public Prueba() {
    }
}
