package threads.ejemploexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploScheduleExecutorService {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main...");
        executor.schedule(() -> {
            System.out.println("Hola mundo tarea...");

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 3000, TimeUnit.MILLISECONDS);

        System.out.println("Alguna otra tarea en el main...");
        executor.shutdown();
    }
}
