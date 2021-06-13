package edu.pingpong.quickstart;

import org.junit.experimental.categories.Categories;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.Set;

@Path("/HollyGrail")
public class HollyGrailResource {
    @Inject
    HollyGrailService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hollyGrailWar() {
        return "Bienvenido a la guerra del santo grial";
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Master> list(){
        return service.list();
    }

    @GET
    @Path("/master/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMaster(@PathParam("nombre") String nombre){
        Optional<Master> master = service.getMaster(nombre);
        return master.isPresent()?
                Response.status(Response.Status.OK).entity(master.get()).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/servant/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServant(@PathParam("nombre") String nombre){
        Optional<Servant> servant = service.getServant(nombre);
        return servant.isPresent()?
                Response.status(Response.Status.OK).entity(servant.get()).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/asociacion/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAsociacion(@PathParam("nombre") String nombre){
        Optional<Asociacion> asociacion = service.getAociacion(nombre);
        return asociacion.isPresent()?
                Response.status(Response.Status.OK).entity(asociacion.get()).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }
    @POST
    @Path("/master")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<Master> add(Master master){
        service.add(master);
        return this.list();
    }
    @POST
    @Path("/servant")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void addServant(Servant servant){
        service.addServant(servant);
    }
    @POST
    @Path("/prueba")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void add(Prueba prueba){
        service.addPrueba(prueba);
    }
    @DELETE
    @Path("/servant")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void deleteServant(Servant servant){
        service.deleteServant(servant);
    }
}