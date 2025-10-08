package org.example;

public class HiloDeIngresos extends Thread{
    public HiloDeIngresos(){
        setName("Hilo de ingresos");
    }

    @Override
    public void run() {
        for (int i = 0; i<5000;i++) {
            Caja.capital += 10;
            System.out.println(Caja.capital);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
