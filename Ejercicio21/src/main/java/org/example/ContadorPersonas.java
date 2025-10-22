package org.example;

public class ContadorPersonas {
    private static int contadorPersonas=0;
    public static void aumentarContador (){
        contadorPersonas++;
    }
    public static int devolverContador(){
        return contadorPersonas;
    }
}
