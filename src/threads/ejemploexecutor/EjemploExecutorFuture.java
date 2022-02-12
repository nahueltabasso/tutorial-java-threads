package threads.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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

        Future<String> resultado = executorService.submit(tarea);
        executorService.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");

        while (!resultado.isDone()) {
            System.out.println("Ejecutando tarea...");
            Thread.sleep(1000);
        }
        System.out.println(resultado.isDone());
        System.out.println("Resultado de la tarea " + resultado.get());
        System.out.println("Finaliza la tarea: " + resultado.isDone());
    }
}
