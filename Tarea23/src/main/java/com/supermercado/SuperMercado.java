package com.supermercado;

import java.util.concurrent.Semaphore;

public class SuperMercado {
    private int [] cajas;
    private final Semaphore semaforo;

    public SuperMercado(int cantidadCajas, Semaphore semaforo) {
        this.semaforo = semaforo;
        cajas = new int[cantidadCajas];
    }

    public void atenderCliente(int numCliente){
        while (true) {
            int cajaElegida = (int) (Math.random() * cajas.length);

            try {
                semaforo.acquire(); // intenta conseguir una caja

                if (cajas[cajaElegida] == 0) {
                    cajas[cajaElegida] = numCliente;
                    System.out.println("Cliente " + numCliente + " entra en la caja " + cajaElegida);
                    //añadimos dinero random a la caja
                    CajaDinero.aumentarDinero((int)(Math.random() * 100) + 1);
                    break; // sale del while
                } else {
                    // Caja ocupada, devolvemos el turno del semáforo
                    semaforo.release();
                }

            } catch (InterruptedException e) {
                System.out.println("Error con cliente " + numCliente);
            }
        }
    }


    public void salirDeCaja(int num){
        for (int i = 0; i < cajas.length; i++) {
            if (cajas[i] == num) {
                cajas[i] = 0;
                System.out.println("Cliente " + num + " sale de la caja " + i);
                semaforo.release(); // deja libre la caja
                break;
            }
        }
    }

    private static void esperandoEnCola(int numCliente) {
        int tiempoAtencion = (int)(Math.random() * 3000) + 1000;
        try {
            Thread.sleep(tiempoAtencion);
        } catch (InterruptedException e) {
            System.out.println("Error en el tiempo de atencion del cliente " + numCliente);
        }
    }


    public int[] getCajas() {
        return cajas;
    }

    public void setCajas(int[] cajas) {
        this.cajas = cajas;
    }
}
