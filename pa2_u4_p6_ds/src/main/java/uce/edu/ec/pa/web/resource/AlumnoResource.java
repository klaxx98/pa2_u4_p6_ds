package uce.edu.ec.pa.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import uce.edu.ec.pa.application.service.AlumnoService;
import uce.edu.ec.pa.domain.model.Alumno;

@Path("/alumnos")
public class AlumnoResource {

    @Inject
    private AlumnoService alumnoService;

    public Alumno buscarPorId(Integer id) {
        return this.alumnoService.buscarPorId(id);

    }

}
