package org.example;

public class HiloT13 extends Thread {

    public HiloT13(String name, int prioridad){
        setName(name);
        setPriority(prioridad);
    }
    @Override
    public void run() {
        for (int i = 0; i<10;i++){
            System.out.println("["+getName()+"]"+"Estamos en la iteracion "+i+ "[PRIORIDAD = "+getPriority()+"]");
            try {
                sleep(tiempoAleatorio());
            } catch (InterruptedException e) {
                System.out.println("Fallo al dormir el hilo: "+e);
            }

        }
    }
    public static int tiempoAleatorio(){
        return (int) (Math.random()*9001)+1000;
    }
}


