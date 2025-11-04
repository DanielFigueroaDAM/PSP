package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Dime una direccion de dominio");
        String dominio = tec.next();

        try {
            InetAddress ip = InetAddress.getByName(dominio);
            System.out.println("La direccion IP de " + dominio + " es: " + ip.getHostAddress());
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("La direccion IP local es: " + local.getHostAddress());
            System.out.println("El nombre de la maquina local es: " + local.getHostName());

        } catch (UnknownHostException e) {
            System.out.println("No se pudo resolver el dominio: " + dominio+" e.getMessage()");
        }

    }
}