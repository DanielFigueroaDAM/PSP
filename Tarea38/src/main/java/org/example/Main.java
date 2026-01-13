package org.example;

import javax.swing.*;
import java.security.MessageDigest;
import java.util.HexFormat;

public class Main {
    public static void main(String[] args) {
        try {
            // Estoy cansado de los escaner
            JOptionPane.showMessageDialog(null, "Fase de  registro ");
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            String contrasena = JOptionPane.showInputDialog( "Introduce la contraseña a cifrar:" );

            String contrasenaGuardada = cifrarContrasena(md, contrasena);

            JOptionPane.showMessageDialog(null, "Fase de  login ");
            JOptionPane.showMessageDialog(null, "Usuario registrado. Inicie sesión para probar.");

            String contrasenaLogin = JOptionPane.showInputDialog( "Introduce la contraseña para iniciar sesión:" );

            String contrasenaLoginCifrada = cifrarContrasena(md, contrasenaLogin);

            JOptionPane.showMessageDialog(null, "Resultado");

            // Comparamos las contraseñas cifradas
            String resultado = contrasenaLoginCifrada.equals( contrasenaGuardada ) ? "Acceso concedido." : "Credenciales inválidas";

            JOptionPane.showMessageDialog(null, resultado);

        }catch ( Exception e) {
            System.out.println( "Exception: " + e.getMessage() );
        }
    }

    private static String cifrarContrasena(MessageDigest md, String contrasena) {
        md.update(contrasena.getBytes());
        byte[] digest = md.digest();
        return HexFormat.of().formatHex(digest);
    }
}