package threads.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFutureMultipleTareas {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        System.out.println("Tamaño del pool: " + executorService.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executorService.getQueue().size());

        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.out.println("Finaliza la tarea...");
            return "Algun resultado importante de la tarea";
        };

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 3");
            TimeUnit.SECONDS.sleep(5);
            return 10;
        };

        Future<String> resultado = executorService.submit(tarea);
        Future<String> resultado2 = executorService.submit(tarea);
        Future<Integer> resultado3 = executorService.submit(tarea2);

        System.out.println("Tamaño del pool: " + executorService.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executorService.getQueue().size());

        executorService.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");

        while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())) {
            System.out.println("Ejecutando tarea...");
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    resultado.isDone() ? "finalizo" : "en proceso",
                    resultado2.isDone() ? "finalizo" : "en proceso",
                    resultado3.isDone() ? "finalizo" : "en proceso"));
            Thread.sleep(1000);
        }
        System.out.println(resultado.isDone());
        System.out.println("Resultado de la tarea " + resultado.get());
        System.out.println("Finaliza la tarea: " + resultado.isDone());
    }
}
