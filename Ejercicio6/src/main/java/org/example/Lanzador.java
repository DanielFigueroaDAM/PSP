package org.example;

public class Lanzador {
    public static String ip = Interfaz.pedirIP();
    public static void llamada(){
        ProcessBuilder procesoB = new ProcessBuilder();

        String [] comando = {"ping","-c","4",ip};
        procesoB.command(comando);
        procesoB.inheritIO();
        try {
            Process proceso = procesoB.start();
            proceso.waitFor();
        }catch ( Exception e){
            e.printStackTrace();
        }

    }

}
