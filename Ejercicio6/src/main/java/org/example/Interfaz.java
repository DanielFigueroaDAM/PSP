package org.example;

import java.util.Scanner;

public class Interfaz {
    public static String pedirIP(){
        String ip = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la IP del servidor: ");
        ip = scanner.nextLine();
        scanner.close();
        return ip;
    }
}
