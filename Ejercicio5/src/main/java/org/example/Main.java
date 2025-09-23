package org.example;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int exitCode;
        String comando;
        do {
            System.out.println("Introduce un comando para ejecutar, y sus parametros si los tiene(separa cada uno con un espacio):");
            System.out.println("si quieres salir escriba la palabra 'salir'");
            comando = tec.nextLine();
            if(comando.isEmpty()) // Si el String está vacio  volver saltarse, volver a iterar
                continue;
            var partes = comando.split(" "); //Convierte a un array de Strings la palabra leida
            ProcessBuilder pb = new ProcessBuilder(partes);
            try {
                Process p = pb.start();
                exitCode = p.waitFor();
                System.out.println("El codigo de finalizacion es "+exitCode);
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al ejecutar el comando: " + e.getMessage());
            }
        } while (!comando.equals("salir"));

        tec.close();
    }
}