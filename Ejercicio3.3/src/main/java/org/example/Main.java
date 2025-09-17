package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner tec = new Scanner(System.in);
    //Comprobar si el sistema es windows
    static boolean esWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
    public static void main(String[] args) {
        System.out.println("Introduce el nombre del archivo o su ruta completa (incluyendo la extensión):");
        String filePath = tec.nextLine();
        // Si el sistema es windows se asigna el "notepad", si no, se asigna el editor de el linux de clase.
        String editorTextos = esWindows ? "notepad" : "gnome-text-editor";
        String[] datos = {editorTextos, filePath};
        try {
            Runtime.getRuntime().exec(datos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}