package uce.edu.ec.pa.application.service;

import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaBancariaService {

    public BigDecimal agregarMonto(String numeroCuenta, BigDecimal monto) {

        System.out.println("ID del hilo " + Thread.currentThread().threadId());

        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {

        }

        BigDecimal saldo = BigDecimal.valueOf(1000);
        saldo = saldo.add(monto);
        return saldo;

    }

    public BigDecimal restarMonto(String numeroCuenta, BigDecimal monto) {

        System.out.println("ID del hilo " + Thread.currentThread().threadId());

        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {

        }

        BigDecimal saldo = BigDecimal.valueOf(2000);
        saldo = saldo.subtract(monto);
        return saldo;

    }

    public Uni<BigDecimal> agregarMontoPromesa(String numeroCuenta, BigDecimal monto) {

        System.out.println("ID del hilo " + Thread.currentThread().threadId());

        // agrega el método
        return Uni.createFrom().item(this.agregarMonto(numeroCuenta, monto));

    }

    public Uni<BigDecimal> restarMontoPromesa(String numeroCuenta, BigDecimal monto) {

        System.out.println("ID del hilo " + Thread.currentThread().threadId());

        // programa a traves de un lambda
        return Uni.createFrom().item(()-> {
                return this.restarMonto(numeroCuenta, monto);

            });

    }

}
