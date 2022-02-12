package threads.ejemploexecutor;

import threads.ejemploSync.Panaderia;
import threads.ejemploSync.runnable.Consumidor;
import threads.ejemploSync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        System.out.println("Tamaño del pool: " + executorService.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executorService.getQueue().size());


        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 3");
            TimeUnit.SECONDS.sleep(5);
            return 10;
        };

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);
        Future<?> future1 = executorService.submit(productor);
        Future<?> future2 = executorService.submit(consumidor);

        System.out.println("Tamaño del pool: " + executorService.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executorService.getQueue().size());

        executorService.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");

    }
}
