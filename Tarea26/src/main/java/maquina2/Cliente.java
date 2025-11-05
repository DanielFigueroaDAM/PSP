package maquina2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        InetSocketAddress dir = new InetSocketAddress("localhost", 6666);
        try {
            Socket socket = new Socket();
            socket.connect(dir);
            System.out.println("Conectado al servidor");

            // Enviar mensajes
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
            escritor.println("Mensaje 1 enviado por Cliente");
            escritor.println("Mensaje 2 enviado por Cliente");
            escritor.println("Mensaje 3 enviado por Cliente");

            // Cerrar solo el output stream para indicar fin de envío
            socket.shutdownOutput();

            // Leer respuesta del servidor
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String mensaje;
            while ((mensaje = lector.readLine()) != null) {
                System.out.println("Servidor dice: " + mensaje);
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}