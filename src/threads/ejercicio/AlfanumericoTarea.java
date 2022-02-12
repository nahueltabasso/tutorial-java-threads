package threads.ejercicio;

public class AlfanumericoTarea implements Runnable {

    private Tipo tipo;

    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try {
            if (tipo.equals(Tipo.NUMERO)) {
                for (int i = 1; i < 10; i++) {
                    System.out.println("Numero i = " + i);
                    Thread.sleep(1000L);
                }
            } else {
                for (char i = 'a'; i <= 'z'; i++) {
                    System.out.println("Letra i = " + i);
                    Thread.sleep(1000L);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
