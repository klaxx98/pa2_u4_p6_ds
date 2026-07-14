package uce.edu.ec.pa.application.interceptors;

import java.util.Arrays;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(1)
public class MedirTiempoInterceptor {

    @AroundInvoke
    public Object medir(InvocationContext context) throws Exception {
        long inicio = System.currentTimeMillis();
        try {
            return context.proceed();
        } finally {
            long fin = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución " + context.getMethod().getName() + ": " + (fin - inicio) + " ms");
            System.out.println("Argumentos del método " + context.getMethod().getName() + ": " + Arrays.toString(context.getParameters()));
        }
    }

}
