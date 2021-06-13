package edu.pingpong.quickstart;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name="master")
public class Master extends PanacheEntity {
    @Column(unique = true)
    public String nombre;

    @Column
    public String localidad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="servant_id")
    public Servant servant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="asociacion_id")
    public Asociacion asociacion;

    public Master(String nombre, String localidad, Servant servant, Asociacion asociacion) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.servant = servant;
        this.asociacion = asociacion;
    }

    public Master() {
    }
}
