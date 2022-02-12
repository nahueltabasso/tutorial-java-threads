package threads.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploScheduleExecutorServicePeriodo {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        CountDownLatch lock = new CountDownLatch(5);

        System.out.println("Alguna tarea en el main...");
        Future<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("Hola mundo tarea...");
            lock.countDown();
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 3000, 3000, TimeUnit.MILLISECONDS);


        lock.await();
        future.cancel(true);
        System.out.println("Alguna otra tarea en el main...");
        executor.shutdown();
    }
}
