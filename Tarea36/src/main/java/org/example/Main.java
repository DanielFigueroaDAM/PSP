package org.example;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

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

            msg.setText("Este es el cuerpo del mensaje de prueba.");

            Transport.send(msg);

            Store store = session.getStore("pop3");
            store.connect("pop3.mailtrap.io", 1100, myUser, myPass);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            System.out.println("Tienes " + messages.length + " mensajes en el buzón.");

            int start = Math.max(0, messages.length - 5);
            for (int i = start; i < messages.length; i++) {
                System.out.println("---------------------------------");
                System.out.println("De: " + messages[i].getFrom()[0]);
                System.out.println("Asunto: " + messages[i].getSubject());
            }

            // Cerramos conexiones para liberar recursos
            inbox.close(false);
            store.close();

        } catch (MessagingException e) {
            System.out.println("Error al configurar el mensaje: " + e.getMessage());
        }
    }
}