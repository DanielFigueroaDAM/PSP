package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creación de hilos y configuración de sus propiedades (nombre y prioridad),
        // seguidos de su inicio para ejecutar la tarea definida en el método de1Al1000().
        Thread t1 = new Thread(() -> de1Al1000()); // Hilo 1 ejecutará de1Al1000()
        Thread t2 = new Thread(() -> de1Al1000()); // Hilo 2 ejecutará de1Al1000()
        Thread t3 = new Thread(() -> de1Al1000()); // Hilo 3 ejecutará de1Al1000()
        Thread t4 = new Thread(() -> de1Al1000()); // Hilo 4 ejecutará de1Al1000()
        Thread t5 = new Thread(() -> de1Al1000()); // Hilo 5 ejecutará de1Al1000()

        // Asignación de nombres a los hilos para identificarlos en la salida.
        t1.setName("Hilo 1");
        t2.setName("Hilo 2");
        t3.setName("Hilo 3");
        t4.setName("Hilo 4");
        t5.setName("Hilo 5");

        // Configuración de prioridades para los hilos (1 = más baja, 10 = más alta).
        t1.setPriority(1); // Prioridad más baja
        t2.setPriority(3);
        t3.setPriority(4);
        t4.setPriority(5);
        t5.setPriority(10); // Prioridad más alta entre los hilos creados

        // Cuanta mas alta es la prioridad, mas posibilidades tiene el hilo de ser ejecutado antes

        // Inicio de los hilos para que ejecuten la tarea definida en de1Al1000().
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    public static void de1Al1000() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}