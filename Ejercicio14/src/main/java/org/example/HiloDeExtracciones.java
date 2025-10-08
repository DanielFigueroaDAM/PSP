package org.example;

public class HiloDeExtracciones extends Thread{
    public HiloDeExtracciones() {
        setName("Hilo de extracciones");
    }
    @Override
    public void run() {
        for (int i = 0; i<3000;i++) {
            Caja.capital -= 10;
            System.out.println(Caja.capital);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
