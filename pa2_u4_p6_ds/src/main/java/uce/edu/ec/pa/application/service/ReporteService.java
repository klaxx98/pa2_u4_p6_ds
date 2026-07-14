package uce.edu.ec.pa.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Reporte;
import uce.edu.ec.pa.infrastructure.repository.ReporteRepositoryImpl;

@ApplicationScoped
@Transactional
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;

    public void guardar(Reporte reporte) {
        this.reporteRepositoryImpl.persist(reporte);

    }

    public List<Reporte> buscarTodos() {
        return (List<Reporte>) this.reporteRepositoryImpl.findAll();

    }

    public Reporte buscarPorId(Integer id) {
        return this.reporteRepositoryImpl.findById(id);

    }

    public void actualizar(Integer id, Reporte reporte) {

        Reporte reporteBase = this.reporteRepositoryImpl.findById(id);

        reporteBase.setTitulo(reporte.getTitulo());
        reporteBase.setCategoria(reporte.getCategoria());
        reporteBase.setTexto(reporte.getTexto());
        reporteBase.setAutor(reporte.getAutor());
        reporteBase.setFechaCreacion(reporte.getFechaCreacion());
            
        this.reporteRepositoryImpl.persist(reporteBase);

    }

    public void eliminar(Integer id) {
        this.reporteRepositoryImpl.deleteById(id);

    }

}
