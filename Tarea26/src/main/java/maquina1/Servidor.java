package maquina1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

// Servidor modificado
public class Servidor {
    public static void main(String[] args) {
        try {
            InetSocketAddress dir = new InetSocketAddress("localhost", 6666);
            ServerSocket servidor = new ServerSocket();
            servidor.bind(dir);

            System.out.println("Esperando conexiones...");
            Socket socket = servidor.accept();
            System.out.println("Cliente conectado");

            // Leer mensajes del cliente
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String mensaje;
            while ((mensaje = lector.readLine()) != null) {
                System.out.println("Cliente dice: " + mensaje);
            }

            // Ahora enviar respuesta al cliente
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
            escritor.println("Mensaje 1 enviado por Servidor");
            escritor.println("Mensaje 2 enviado por Servidor");
            escritor.println("Mensaje 3 enviado por Servidor");

            // Cerrar conexión
            socket.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}