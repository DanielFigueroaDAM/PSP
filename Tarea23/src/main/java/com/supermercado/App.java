package com.supermercado;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce número de cajas (M): ");
        int m = sc.nextInt();

        System.out.print("Introduce número de clientes (N): ");
        int n = sc.nextInt();

        Semaphore semaforo = new Semaphore(m);
        SuperMercado supermercado = new SuperMercado(m, semaforo);
        Cliente[] clientes = new Cliente[n];
        for (int i = 0; i < n; i++) {
            clientes[i] = new Cliente(i + 1, supermercado);
            clientes[i].start();
        }

        try {
            for (int i = 0; i < n; i++)
                clientes[i].join();

        } catch (InterruptedException e) {
            System.out.println("Error al esperar a los clientes");
        }
        System.out.println("Dinero total recaudado en el supermercado: " + CajaDinero.getDinero() + " unidades monetarias.");

    }
}
