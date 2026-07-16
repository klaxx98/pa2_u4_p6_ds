package uce.edu.ec.pa.web.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.pa.application.service.ReporteService;
import uce.edu.ec.pa.domain.model.Reporte;

@Path("/reportes")
public class ReporteResource {

    @Inject
    private ReporteService reporteService;

    // /reportes/porId
    @Path("/porId/{id}")
    @GET
    public Reporte buscarPorId(@PathParam("id") Integer id) {
        return this.reporteService.buscarPorId(id);

    }

    @Path("/todos")
    @GET
    public List<Reporte> buscarTodos() {
        return this.reporteService.buscarTodos();

    }

    @Path("/guardar")
    @POST
    public void guardar(Reporte reporte) {
        this.reporteService.guardar(reporte);

    }

    @Path("/actualizar/{id}")
    @PUT
    public void actualizar(@PathParam("id") Integer id, Reporte reporte) {
        this.reporteService.actualizar(id, reporte);

    }

    @Path("/eliminar/{id}")
    @DELETE
    public void eliminar(@PathParam("id") Integer id) {
        this.reporteService.eliminar(id);

    }

}
