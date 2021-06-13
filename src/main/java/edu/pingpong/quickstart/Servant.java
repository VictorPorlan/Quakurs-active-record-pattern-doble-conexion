package edu.pingpong.quickstart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name="servant")
public class Servant extends PanacheEntity {
    @Column(unique = true)
    public String nombre;

    @Column
    public String clase;

    @Column
    public String noblePhantasm;

    @JsonIgnore
    @OneToOne(mappedBy = "servant", cascade = CascadeType.ALL)
    public Master master;

    public Servant() {
    }

    public Servant(String nombre, String clase, String noblePhantasm, Master master) {
        this.nombre = nombre;
        this.clase = clase;
        this.noblePhantasm = noblePhantasm;
        this.master = master;
    }
}
