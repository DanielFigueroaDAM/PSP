package maquina2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        InetSocketAddress dir = new InetSocketAddress("localhost", 6666);
        try {
            Scanner tec = new Scanner(System.in);
            Socket socket = new Socket();
            socket.connect(dir);
            System.out.println("Conectado al servidor");

            while (true) {
                System.out.println("Manda un mensaje('adios' para salir): ");
                String mensajeUsuario = tec.nextLine();
                if (mensajeUsuario.equalsIgnoreCase("adios"))
                    break;

                PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
                escritor.println(mensajeUsuario);

//            socket.shutdownOutput();

                BufferedReader lector = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                System.out.println(lector.readLine());


            }
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}