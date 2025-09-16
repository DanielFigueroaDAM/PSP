package org.example;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner tec = new Scanner(System.in);
    public static void main(String[] args) {
//        Crea un programa en Java que permita al usuario, desde la línea de comandos, abrir un archivo existente o crear uno nuevo utilizando un editor de texto sencillo disponible en el sistema (por ejemplo: gnome-text-editor, gedit, notepad, etc.).
//        El usuario deberá introducir por teclado el nombre del archivo o su ruta completa (incluyendo la extensión).
//        Si el archivo no existe, el editor deberá permitir su creación.
        System.out.println("Introduce el nombre del archivo o su ruta completa (incluyendo la extensión):");
        String filePath = tec.nextLine();
        String[] datos = {"gedit", filePath};
        try {
            Runtime.getRuntime().exec(datos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}