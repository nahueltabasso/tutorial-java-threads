package threads.runnable;

import threads.EjemploSincronizacionThread;

public class ImprimirFrase implements Runnable {

    private String frase1;
    private String frase2;

    public ImprimirFrase(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        EjemploSincronizacionThread.imprimirFrase(this.frase1, this.frase2);
    }
}
