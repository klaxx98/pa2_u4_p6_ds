package uce.edu.ec.pa.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Alumno;
import uce.edu.ec.pa.infrastructure.repository.AlumnoRepositoryImpl;

@ApplicationScoped
@Transactional
public class AlumnoService {

    @Inject
    private AlumnoRepositoryImpl alumnoRepo;

    public void guardar(Alumno alumno) {
        this.alumnoRepo.persist(alumno);

    }

    public Alumno buscarPorId(Integer id) {
        return this.alumnoRepo.findById(id);

    }

    public List<Alumno> buscarTodos() {
        return (List<Alumno>) this.alumnoRepo.findAll();

    }

    public void actualizar(Integer id, Alumno alumno) {
        Alumno alumnoBase = this.buscarPorId(id);

        alumnoBase.setApellido(alumno.getApellido());
        alumnoBase.setNombre(alumno.getNombre());
        alumnoBase.setCedula(alumno.getCedula());
        alumnoBase.setFacultad(alumno.getFacultad());
        alumnoBase.setSemestre(alumno.getSemestre());

        this.alumnoRepo.persist(alumnoBase);

    }

    public void eliminar(Integer id) {
        this.alumnoRepo.deleteById(id);

    }

}
