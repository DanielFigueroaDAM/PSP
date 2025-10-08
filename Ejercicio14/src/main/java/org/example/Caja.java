package org.example;

public class Caja {
    public static double capital = 1000.0;

    public static void main(String[] args) throws InterruptedException {
        HiloDeIngresos h1 = new HiloDeIngresos();
        HiloDeExtracciones h2 = new HiloDeExtracciones();
        h1.start();
        h2.start();
        h1.join();
        h1.join();
    }

}
