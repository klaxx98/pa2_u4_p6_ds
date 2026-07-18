package uce.edu.ec.pa.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MailService {

    public void enviarMail(String destino, String asunto, String cuerpo) {

        System.out.println("ID del hilo " + Thread.currentThread().threadId());

        try {
            Thread.sleep(2000);
        } catch(Exception ex) {

        }

        System.out.println("Se envia un mail a: " + destino);

    }

}
