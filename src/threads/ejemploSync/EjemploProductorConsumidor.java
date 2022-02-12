package threads.ejemploSync;

import threads.ejemploSync.runnable.Consumidor;
import threads.ejemploSync.runnable.Panadero;

public class EjemploProductorConsumidor {

    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
