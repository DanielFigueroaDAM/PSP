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

            String miCorreo = "El sistema de notificaciones esta activo";

            msg.setText(miCorreo);

            Transport.send(msg);

            Store store = session.getStore("pop3");
            store.connect("pop3.mailtrap.io", 1100, myUser, myPass);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();


            System.out.println("\n=== ÚLTIMO MENSAJE ENVIADO ===");
            leerUltimoMensajeEnviado(messages);

            // Cerramos conexiones para liberar recursos
            inbox.close(false);
            store.close();

        } catch (MessagingException e) {
            System.out.println("Error al configurar el mensaje: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el contenido");
        }
    }

    private static void leerUltimoMensajeEnviado(Message[] messages) throws MessagingException, IOException {
        if (messages.length == 0) {
            System.out.println("No hay mensajes en el buzón.");
            return;
        }
        // El último mensaje en el array es el más reciente
        Message ultimoMensaje = messages[0];
        System.out.println("De: " + ultimoMensaje.getFrom()[0]);
        System.out.println("Asunto: " + ultimoMensaje.getSubject());

    }
}