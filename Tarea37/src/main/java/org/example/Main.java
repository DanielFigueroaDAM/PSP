package org.example;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean continuar = true;
        String textoParaCifrar;
        int desplazamiento = 0;
        do{
        textoParaCifrar = JOptionPane.showInputDialog("Introduce el texto a cifrar:");
        try {
            String desplazamientoStr = JOptionPane.showInputDialog("Introduce el desplazamiento (número entero):");
            desplazamiento = Integer.parseInt(desplazamientoStr);
            continuar = true;
        }catch ( NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El desplazamiento debe ser un número entero. Inténtalo de nuevo.");
            continuar = false;
        }
        }while (!continuar);

        CifradorCesar miCifrador = new CifradorCesar(textoParaCifrar,desplazamiento);

        JOptionPane.showMessageDialog(null,miCifrador.cifrar());




    }
}