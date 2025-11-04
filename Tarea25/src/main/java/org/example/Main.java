package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int [] puestos = {21,22,80,443};
        boolean esCorrecto = false;
        Scanner tec = new Scanner(System.in);
        String ip;
        do {
            System.out.println("Dame la ip(escribe 'salir' para salir del programa):");
            ip = tec.next();
            if(ip.equals("salir")){
                System.out.println("Saliendo del programa...");
                break;
            }
            do {
                System.out.println("Quieres indicar el puerto? (s/n)");
                String respuesta = tec.next();
               switch (respuesta.toLowerCase()) {
                   case "s": {
                       System.out.println("Dame el puerto");
                       int puerto = tec.nextInt();
                       analizarPuertoSeleccionado(puerto, ip);
                       esCorrecto = true;
                       break;
                   }
                   case "n": {
                       analizarPuertosFamosos(puestos, ip);
                       esCorrecto = true;
                       break;
                   }
                   default: {
                       System.out.println("Respuesta no válida, vuelva a intentarlo.");
                       esCorrecto = false;
                       break;
                   }
               }
            }while (!esCorrecto);
        }while (true);
        tec.close();



    }

    private static void analizarPuertoSeleccionado(int puerto, String ip) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(ip, puerto), 1000); // timeout 1s

            System.out.println("El puerto " + puerto + " está abierto.");

        } catch (IOException e) {
            System.out.println("El puerto " + puerto + " está cerrado.");
        }
    }

    private static void analizarPuertosFamosos(int[] puertos, String ip) {
        for (int puerto : puertos) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(ip, puerto), 1000);

                System.out.println("El puerto " + puerto + " está abierto.");

            } catch (IOException e) {
                System.out.println("El puerto " + puerto + " está cerrado.");
            }
        }
    }

}