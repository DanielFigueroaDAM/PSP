package maquina1;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket()) {
            InetSocketAddress dir = new InetSocketAddress("localhost", 6666);
            servidor.bind(dir);

            System.out.println("Esperando conexiones...");

            while (true) {
                try {
                    Socket socket = servidor.accept();
                    new HiloServidor(socket).start();
                } catch (Exception e) {
                    System.out.println("Error aceptando conexión: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}