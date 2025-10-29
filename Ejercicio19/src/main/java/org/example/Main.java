package org.example;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static int contadorVocales = 0;
    private final static Object lock = new Object();
    public static void main(String[] args) {

        String palabraTemp = "";
        try (FileInputStream fis = new FileInputStream("text.txt")) {
            byte[] datos = fis.readAllBytes();
            palabraTemp = new String(datos);
        } catch (IOException e) {
            System.out.println( "Error al leer el archivo: " + e.getMessage());
        }

        final String palabra = palabraTemp;


        Thread A = new Thread(()->cuentaLetras('a',palabra));
        Thread E = new Thread(()->cuentaLetras('e',palabra));
        Thread I = new Thread(()->cuentaLetras('i',palabra));
        Thread O = new Thread(()->cuentaLetras('o',palabra));
        Thread U = new Thread(()->cuentaLetras('u',palabra));
        A.start();
        E.start();
        I.start();
        O.start();
        U.start();
        try {
            A.join();
            E.join();
            I.join();
            O.join();
            U.join();
        }catch (InterruptedException e) {
            System.out.println( "Error al leer el archivo: " + e.getMessage() );
        }
        System.out.println(contadorVocales);
    }
    public static void cuentaLetras(Character letra, String palabra){
        for(Character n : palabra.toCharArray()){
            if(n == letra || n == Character.toUpperCase(letra)){
                synchronized (lock) {
                    contadorVocales++;
                }
            }
        }
    }
}