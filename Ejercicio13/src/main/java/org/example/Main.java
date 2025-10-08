package org.example;


public class Main {
    public static void main(String[] args) {
        HiloT13 h1 = new HiloT13("hilo1", 10);
        HiloT13 h2 = new HiloT13("hilo2", 1);
        HiloT13 h3 = new HiloT13("hilo3", 3);
        HiloT13 h4 = new HiloT13("hilo4", 4);
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        //hilosConLambdas();
    }

    public static void hilosConLambdas(){
        Thread hl1 = new Thread(Main::interaciones10);
        Thread hl2 = new Thread(Main::interaciones10);
        Thread hl3 = new Thread(Main::interaciones10);
        Thread hl4 = new Thread(Main::interaciones10);
        hl1.start();
        hl2.start();
        hl3.start();
        hl4.start();

    }
    public static void interaciones10(){
        for (int i = 0; i<10;i++){
            System.out.println("["+Thread.currentThread().getName()+"]"+"Estamos en la iteracion "+i+ "[PRIORIDAD = "+Thread.currentThread().getPriority()+"]");
            try {
                Thread.sleep(HiloT13.tiempoAleatorio());
            } catch (InterruptedException e) {
                System.out.println("Fallo al dormir el hilo: "+e);
            }
        }
    }
}