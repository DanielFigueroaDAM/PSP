package org.example;

public class Torno extends Thread{
    private final Object candado;
    private int cantidadPersonas;

    public Torno(Object candado,int cantidadPersonas){
        this.cantidadPersonas = cantidadPersonas;
        this.candado = candado;
    }

    @Override
    public void run() {
        for (int i = 0;i<cantidadPersonas;i++) {
            synchronized (candado){
                ContadorPersonas.aumentarContador();
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
