package threads;

import threads.runnable.ViajeTarea;

public class EjemploInterfazRunnable {

    public static void main(String[] args) {
        new Thread(new ViajeTarea("Cancun")).start();
        new Thread(new ViajeTarea("Barcelona")).start();
        new Thread(new ViajeTarea("Miami")).start();
        new Thread(new ViajeTarea("Las Vegas")).start();
    }
}
