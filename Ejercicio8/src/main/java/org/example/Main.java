package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Profesor profesor = new Profesor("Damian", 2);
        Profesor profesor2 = new Profesor("Elena", 9);
        Profesor profesor3 = new Profesor("Diego", 5);
        Profesor profesor4 = new Profesor("Manuel", 9);
        profesor.start();
        profesor2.start();
        profesor3.start();
        profesor4.start();
        Thread.sleep(10);
        System.out.println("Programa principal finalizado");

    }
}