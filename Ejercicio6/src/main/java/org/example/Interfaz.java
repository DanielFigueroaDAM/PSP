package org.example;

import java.util.Scanner;

public class Interfaz {
    private static Scanner scanner = new Scanner(System.in);
    public static String pedirIP(){
        String ip = "";
        System.out.println("Introduce la IP del servidor: ");
        ip = scanner.nextLine();

        return ip;
    }
    public static void cerrarScanner(){
        scanner.close();
    }
}
