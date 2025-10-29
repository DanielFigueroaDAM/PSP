package repaso.cincoHilos;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class App {
    private static int contador =0;
    public static void main(String[] args) {

        Object candado = new Object();
        Thread h1 = new Thread(()->añadir50(candado));
        Thread h2 = new Thread(()->añadir50(candado));
        Thread h3 = new Thread(()->añadir50(candado));
        Thread h4 = new Thread(()->añadir50(candado));
        Thread h5 = new Thread(()->añadir50(candado));
        h1.start(); h2.start(); h3.start(); h4.start(); h5.start();
        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
            h5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(contador);
    }
    public static void añadir50(Object o){
        for (int i = 0;i<50;i++){
            synchronized (o){
                contador++;
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
