package uce.edu.ec.pa.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import uce.edu.ec.pa.application.service.TransferenciaService;

@Path("/transferencia")
public class RecursoTransferencia {

    @Inject
    private TransferenciaService transferenciaService;

    @Path("/realizar")
    @POST
    public String realizarTransferencia(TransferenciaResource transferencia) {
        return this.transferenciaService.realizarTransferencia(transferencia.getCuentaOrigen(),
                                                                transferencia.getCuentaDestino(),
                                                                transferencia.getMonto());

    }

    @Path("/realizarReactiva")
    @POST
    public String realizarTransferenciaReactiva(TransferenciaResource transferencia) {
        return this.transferenciaService.realizarTransferenciaReactiva(transferencia.getCuentaOrigen(),
                                                                transferencia.getCuentaDestino(),
                                                                transferencia.getMonto());

    }

}
