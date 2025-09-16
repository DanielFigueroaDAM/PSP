package org.example;

import java.util.Arrays;
import java.util.Properties;

public class ObtencionDatos {
    static Runtime rt = Runtime.getRuntime();
    public static String datosDeMemoria(){

        long memoriaTotal =rt.totalMemory()/1024;
        long memoriaLibre=rt.freeMemory()/1024;
        long memoriaEnUso=(rt.totalMemory() - rt.freeMemory())/1024;
        return "Memoria total: "+memoriaTotal+"\n"+"Memoria Libre: "+memoriaLibre+"\n"+"Memoria en uso: "+memoriaEnUso;
    }
    public static int numeroProcesadores(){
        return rt.availableProcessors();
    }
    public static void propiedadesSystem(){
        Properties propiedades = System.getProperties();
        String[] listaPropiedades = propiedades.toString().split(", ");
        Arrays.stream(listaPropiedades).forEach(System.out::println);
    }


}
