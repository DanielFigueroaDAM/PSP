package org.example;

import java.io.File;
import java.io.IOException;


public class Main {
    static boolean esWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
    public static void main(String[] args) {

        ProcessBuilder proceso;

        if(esWindows)
            proceso = new ProcessBuilder("cmd", "/c", "dir");
        else
            proceso = new ProcessBuilder("ls", "-l");

        String userDir = System.getProperty("user.dir");
        System.out.println("Directorio de trabajo actual: " + userDir);
        proceso.directory(new File(userDir));

        try {
            Process proceso2 = proceso.start();
        } catch (IOException e) {
            System.out.println("Error al ejecutar el proceso " + e.getMessage());
        }

        String userHome = System.getProperty("user.home");

        System.setProperty("user.dir", userHome);

        System.out.println("Directorio de trabajo tras el cambio: " + userHome);
        System.out.println("Propiedad user.dir tras el cambio: " + System.getProperty("user.dir"));

        String tempDir = esWindows ? "C:\\temp" : "/tmp";

        System.setProperty("user.dir", tempDir);

        System.out.println("Directorio de trabajo tras el cambio: " + tempDir);
        System.out.println("Propiedad user.dir tras el cambio: " + System.getProperty("user.dir"));
    }


}