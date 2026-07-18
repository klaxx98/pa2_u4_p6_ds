package uce.edu.ec.pa.application.service;

import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TransferenciaService {

    @Inject
    private CuentaBancariaService bancariaService;

    @Inject
    private MailService mailService;

    @Inject
    private AuditoriaService auditoriaService;

    public String realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {

        System.out.println("ID del hilo " + Thread.currentThread().threadId());

        long inicio = System.currentTimeMillis();

        Uni<BigDecimal> saldoD = this.bancariaService.agregarMontoPromesa(cuentaDestino, monto);
        Uni<BigDecimal> saldoO = this.bancariaService.restarMontoPromesa(cuentaDestino, monto);

        BigDecimal saldoDestino = this.bancariaService.agregarMonto(cuentaDestino, monto);
        BigDecimal saldoOrigen = this.bancariaService.restarMonto(cuentaDestino, monto);

        this.mailService.enviarMail("destino@mail.com", "asunto", "origen@mail.com");
        this.auditoriaService.guardar("Auditoria");
        String mensaje = "Se realizó con éxito, su saldo destino es " + saldoDestino + ", su saldo origen es " + saldoOrigen;

        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;

        System.out.println("Tiempo demora: " + tiempo + " ms");
        return mensaje;

    }

    public String realizarTransferenciaReactiva(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {

        System.out.println("ID del hilo " + Thread.currentThread().threadId());

        long inicio = System.currentTimeMillis();

        Uni<BigDecimal> saldoDestino = this.bancariaService.agregarMontoPromesa(cuentaDestino, monto);
        Uni<BigDecimal> saldoOrigen = this.bancariaService.restarMontoPromesa(cuentaDestino, monto);

        this.mailService.enviarMail("destino@mail.com", "asunto", "origen@mail.com");
        this.auditoriaService.guardar("Auditoria");

        Uni.combine().all().unis(saldoDestino, saldoOrigen).asTuple().map(resultado -> {
            String mensaje = "Se realizó con éxito, su saldo destino es " + resultado.getItem1() + ", su saldo origen es " + resultado.getItem2();
            System.out.println(mensaje);
            return mensaje;
        });

        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;

        System.out.println("Tiempo demora: " + tiempo + " ms");
        return "Finalizado";

    }

}
