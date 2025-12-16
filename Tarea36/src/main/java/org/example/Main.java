package org.example;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // 1. Configuración de las Propiedades (El "Diccionario")
        Properties props = new Properties();
        props.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        props.put("mail.smtp.port", "2525");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        //Usuario y contraseña de Mailtrap
        String myUser = "69a44ea40af523";
        String myPass = "d5ae6c8135c499";
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myUser, myPass);
            }
        });

        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress("agente@java.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("prueba@destino.com"));
            msg.setSubject("Prueba de Agente - [Daniel]");

            String miCorreo = JOptionPane.showInputDialog("Escribe el correo");

            msg.setText(miCorreo);

            Transport.send(msg);

            Store store = session.getStore("pop3");
            store.connect("pop3.mailtrap.io", 1100, myUser, myPass);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);


            Message[] messages = inbox.getMessages(); // leemos los mensajes del correo

            System.out.println("Ultimo mensaje");
            System.out.println("--------------------------------");
            leerUltimoMensajeEnviado(messages);


            System.out.println("Primeros 5 mensajes ");
            System.out.println("--------------------------------");
            leer5PrimerosMensajes(messages);

            // Cerramos conexiones para liberar recursos
            inbox.close(false);
            store.close();

        } catch (MessagingException e) {
            System.out.println("Error al configurar el mensaje: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el contenido");
        }
    }

    /**
     * Esta función se encarga de leer los 5 primeros mensajes.
     * @param messages
     * @throws MessagingException
     */
    private static void leer5PrimerosMensajes(Message[] messages) throws MessagingException, IOException {
        System.out.println("Tienes " + messages.length + " mensajes en el buzón.");
        System.out.println("--------------------------------");

        int totalMensajes = messages.length;
        int start = Math.max(0, totalMensajes - 5);

        for (int i = start; i < totalMensajes; i++) {
            System.out.println("---------------------------------");
            try {
                // El mensaje en posición i del array corresponde al mensaje #(i+1) en POP3
                System.out.println("Mensaje #" + (i + 1) + ":");
                System.out.println("De: " + messages[i].getFrom()[0]);
                System.out.println("Asunto: " + messages[i].getSubject());
                System.out.println("Contenido: " + messages[i].getContent().toString());
            } catch (MessageRemovedException e) {
                System.out.println("Mensaje #" + (i + 1) + " ha sido eliminado o no existe");
            } catch (MessagingException e) {
                System.out.println("Error al leer mensaje #" + (i + 1) + ": " + e.getMessage());
            }
        }
    }
    private static void leerUltimoMensajeEnviado(Message[] messages) throws MessagingException, IOException {
        if (messages.length == 0) {
            System.out.println("No hay mensajes en el buzón.");
            return;
        }

        // El último mensaje en el array es el más reciente en POP3
        Message ultimoMensaje = messages[messages.length - 1];

        System.out.println("=== ÚLTIMO MENSAJE ENVIADO ===");
        System.out.println("De: " + ultimoMensaje.getFrom()[0]);
        System.out.println("Asunto: " + ultimoMensaje.getSubject());
        System.out.println("Fecha: " + ultimoMensaje.getSentDate());

        // Leer contenido
        Object contenido = ultimoMensaje.getContent();
        if (contenido != null) {
            System.out.println("Contenido: " + contenido.toString());
        }
        System.out.println("=============================");
    }


}