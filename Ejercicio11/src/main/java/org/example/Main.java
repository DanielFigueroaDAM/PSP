package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static Thread[] hilos = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero de hilos a crear: ");
        int tamañoLista = sc.nextInt();
        sc.close();
        crearHilos(tamañoLista);
        hilos[0].start();
    }

    public static void crearHilos(int tamañoLista) {
        tamañoLista = (tamañoLista <= 0) ? 5 : tamañoLista; // Si el numero es negativo o 0, se asigna 5
        hilos = new Thread[tamañoLista];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(Main::lazadorHilos); // Se le pasa la funcion anonima(Method Reference)
            hilos[i].setName("Hilo " + (i + 1));
        }
    }
    static int hilo = 0;
    public static void lazadorHilos(){

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("["+Thread.currentThread().getName() +"]" + "Iteracion " + (i+1));
                Thread.sleep(500);
                if (i == 4 && ++hilo < hilos.length) { // Hacemos el preincremento de la variable hilo y se comprueba para no pasarse del array
                    hilos[hilo].start();// llama al siguiente hilo que ejecuta este metodo(parece recursivo pero no lo es)
                    hilos[hilo].join();
                }
            }
        }
        catch (InterruptedException er) {
            System.out.println("[" + Thread.currentThread().getName() + "]" + "Interrumpido");
            return; // Salimos del metodo si es interrumpido
        }
        System.out.println("["+Thread.currentThread().getName() +"]" + "Termina");

    }
}