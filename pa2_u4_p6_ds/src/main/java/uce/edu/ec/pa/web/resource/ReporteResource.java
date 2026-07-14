package uce.edu.ec.pa.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import uce.edu.ec.pa.application.service.ReporteService;
import uce.edu.ec.pa.domain.model.Reporte;

@Path("/reportes")
public class ReporteResource {

    @Inject
    private ReporteService reporteService;

    public Reporte buscarPorId(Integer id) {
        return this.reporteService.buscarPorId(id);

    }

}
