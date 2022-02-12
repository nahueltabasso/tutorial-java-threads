package threads.ejercicio;

public class MainEjercicio {

    public static void main(String[] args) {
        AlfanumericoTarea tareaNumeros = new AlfanumericoTarea(Tipo.NUMERO);
        AlfanumericoTarea tareaLetras = new AlfanumericoTarea(Tipo.LETRA);

        Thread thread1 = new Thread(tareaLetras);
        Thread thread2 = new Thread(tareaNumeros);

        thread1.start();
        thread2.start();
    }
}
