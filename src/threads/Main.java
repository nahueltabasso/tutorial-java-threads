package threads;

import threads.thread.NombreThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new NombreThread("Test");
        thread.start();
        // Thread.sleep(100);
        Thread thread2 = new NombreThread("Test 2");
        thread2.start();

        Thread thread3 = new NombreThread("Test 3");
        thread3.start();
        System.out.println(thread.getState());
    }
}
