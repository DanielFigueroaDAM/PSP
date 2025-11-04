package com.supermercado;

import java.util.concurrent.Semaphore;

public class Cliente extends Thread{
    private int numeroCliente;
    private SuperMercado supermercado;

    @Override
    public void run() {
        supermercado.atenderCliente(numeroCliente);
        enLaCajaTiempoRandom();
        supermercado.salirDeCaja(numeroCliente);
    }

    public Cliente(int numeroCliente, SuperMercado supermercado) {
        this.numeroCliente = numeroCliente;
        this.supermercado = supermercado;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
    private void enLaCajaTiempoRandom(){
        // Simula el tiempo que tarda un cliente en comprar entre 1 y 5 segundos
        int tiempoCompra = (int)(Math.random() * 5000) + 1000;
        try {
            Thread.sleep(tiempoCompra);
        } catch (InterruptedException e) {
            System.out.println("Error en el tiempo de compra del cliente " + numeroCliente);
        }
    }

}
