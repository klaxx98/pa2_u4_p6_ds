package uce.edu.ec.pa.web.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.pa.application.service.AlumnoService;
import uce.edu.ec.pa.domain.model.Alumno;

@Path("/alumnos")
public class AlumnoResource {

    @Inject
    private AlumnoService alumnoService;

    @Path("/porId/{id}")
    @GET
    public Alumno buscarPorId(@PathParam("id") Integer id) {
        return this.alumnoService.buscarPorId(id);

    }

    @Path("/todos")
    @GET
    public List<Alumno> buscarTodos() {
        return this.alumnoService.buscarTodos();

    }

    @Path("/guardar")
    @POST
    public void guardar(Alumno alumno) {
        this.alumnoService.guardar(alumno);

    }

    @Path("/actualizar/{id}")
    @PUT
    public void actualizar(@PathParam("id") Integer id, Alumno alumno) {
        this.alumnoService.actualizar(id, alumno);

    }

    @Path("/eliminar/{id}")
    @DELETE
    public void eliminar(@PathParam("id") Integer id) {
        this.alumnoService.eliminar(id);

    }

}
