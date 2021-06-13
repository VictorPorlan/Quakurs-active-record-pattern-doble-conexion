package edu.pingpong.quickstart;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class HollyGrailService {
    public Set<Master> list() {
        Stream<Master> masters = Master.streamAll();
        return masters.collect(Collectors.toSet());
    }

    public Optional<Master> getMaster(String nombre) {
        return Master.find("nombre", nombre).firstResultOptional();
    }

    public Optional<Servant> getServant(String nombre) {
        return Servant.find("nombre", nombre).firstResultOptional();
    }

    public Optional<Asociacion> getAociacion(String nombre) {
        return Asociacion.find("nombre", nombre).firstResultOptional();
    }

    @Transactional
    public void add(Master master) {
        Optional<Servant> servant = Servant.find("nombre", master.servant.nombre).firstResultOptional();
        if (servant.isPresent()) {
            master.servant = servant.get();
        } else {
            master.servant.persist();
        }
        Optional<Asociacion> asociacion = Asociacion.find("nombre", master.asociacion.nombre).firstResultOptional();
        if (asociacion.isPresent()) {
            master.asociacion = asociacion.get();
        } else {
            master.asociacion.persist();
        }
        master.persist();
    }

    public void addServant(Servant servant) {
        servant.persist();
    }

    @Transactional
    public void deleteServant(Servant servant) {
        Servant servante = Servant.find("nombre", servant.nombre).firstResult();
        servante.delete();
    }

    @Transactional
    public void addPrueba(Prueba prueba){
        prueba.persist();
    }
}
