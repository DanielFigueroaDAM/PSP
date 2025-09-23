package org.example;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int exitCode;
        System.out.println("Introduce un comando para ejecutar, y sus parametros si los tiene(separa cada uno con un espacio):");
        String comando = tec.nextLine();
        String[] partes = comando.split(" ");
        ProcessBuilder pb = new ProcessBuilder(partes);
        try {
            Process p = pb.start();
            exitCode = p.waitFor();
            System.out.println(exitCode);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el comando: " + e.getMessage() );
        }


        tec.close();
    }
}