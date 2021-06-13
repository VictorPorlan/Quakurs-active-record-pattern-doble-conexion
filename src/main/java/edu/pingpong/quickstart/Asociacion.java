package edu.pingpong.quickstart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="asociacion")
public class Asociacion extends PanacheEntity{
    @Column(unique = true)
    public String nombre;

    @Column
    public String pais;

    @JsonIgnore
    @OneToMany(mappedBy = "asociacion")
    public Set<Master> masters;

    public Asociacion(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Asociacion() {
    }
}
