package org.example;

import java.util.Scanner;


public class Main {
    /**
     * Método que solicita un comando al usuario, lo ejecuta y
     * muestra información sobre el programa y su resultado.
     */

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Introduce un comando y sus parametros separados por un espacio:");
        String comand = tec.nextLine();
        String[] parts = comand.split(" ");
        ProcessBuilder pb = new ProcessBuilder(parts);
        pb.inheritIO(); // Redirecciona la entrada/salida del proceso al de la consola actual
        try {
            Process p = pb.start();
            int exitCode = p.waitFor();
            System.out.println("El nombre del programa es "+ parts[0]);
            System.out.println("El código de finalizacion es: " + exitCode);
        } catch (Exception e) {
            System.out.println("Error al ejecutar el comando: " + e.getMessage());
        }
    }
}