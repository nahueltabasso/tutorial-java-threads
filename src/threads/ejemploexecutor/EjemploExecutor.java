package threads.ejemploexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.out.println("Finaliza la tarea...");
        };

        executorService.submit(tarea);
        executorService.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main 1");
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Continuando con la ejecucion del metodo main 2");
    }
}
