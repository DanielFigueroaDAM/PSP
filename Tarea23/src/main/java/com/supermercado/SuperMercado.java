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
        //Entrar en la caja de forma aleatoria
        int cajaElegida = (int)(Math.random() * cajas.length);
        System.out.println("El cliente " + numCliente + " entra en la caja " + cajaElegida);
        //Simular el tiempo que tarda en ser atendido
        esperandoEnCola(numCliente);
        try {
            semaforo.acquire();
            System.out.println("El cliente " + numCliente + " enta en la caja");
            cajas[cajaElegida] = numCliente;
        } catch (InterruptedException e) {
            System.out.println("Error al adquirir el semaforo para el cliente " + numCliente);
        } finally {
            semaforo.release();
        }
    }

    public void salirDeCaja(int num){
        //Tiempo que tarda en salir de la caja
        esperandoEnCola(num);
        for (int i = 0; i < cajas.length; i++) {
            if (cajas[i] == num) {
                try {
                    semaforo.acquire();

                    System.out.println("El cliente " + num + " sale de la caja " + i);
                    cajas[i] = 0;
                } catch (InterruptedException e) {
                    System.out.println("Error al adquirir el semaforo para el cliente " + num);
                } finally {
                    semaforo.release();
                }
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
