package maquina1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
    public static void main(String[] args) {
        try {
            InetSocketAddress dir = new InetSocketAddress("localhost", 6666);
            ServerSocket servidor = new ServerSocket();
            servidor.bind(dir);

            System.out.println("Esperando conexiones...");
            Socket socket = servidor.accept();
            System.out.println("Cliente conectado");

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );



            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
            String mensaje;
            while ( (mensaje = lector.readLine()) != null)
                escritor.println("Eco: "+mensaje);

            socket.close();
            servidor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}