package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Thread[] hilos = new Thread[5];
    public static void main(String[] args) {
        crearHilos();
        hilos[0].start();

    }

    public static void crearHilos() {
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> lazadorHilos());
            hilos[i].setName("Hilo " + (i + 1));
        }
    }
    static int hilo = 0;
    public static void lazadorHilos(){
        for (int i = 0; i < 5; i++) {
            System.out.println("["+Thread.currentThread().getName() +"]" + "Iteracion " + (i+1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("["+Thread.currentThread().getName() +"]" + "Interrumpido");
                return;
            }
            if (i == 4) {
                hilo++;
                if (hilo < hilos.length) {
                    hilos[hilo].start();
                    try {
                        hilos[hilo].join();
                    } catch (InterruptedException e) {
                        System.out.println("[" + Thread.currentThread().getName() + "]" + "Interrumpido");
                        return;
                    }
                }
            }
        }
        System.out.println("["+Thread.currentThread().getName() +"]" + "Termina");

    }
}