package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static int contadorVocales = 0;
    public static void main(String[] args) {

        String palabraTemp = "";
        try (FileInputStream fis = new FileInputStream("text.txt")) {
            byte[] datos = fis.readAllBytes();
            palabraTemp = new String(datos);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
        System.out.println(contadorVocales);
    }
    public synchronized static void cuentaLetras(Character letra, String palabra){
        for(Character n : palabra.toCharArray()){
            if(n == letra || n == Character.toUpperCase(letra)){
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                contadorVocales++;
                System.out.println(contadorVocales  );
            }
        }
    }
}