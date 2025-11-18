package maquina1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread{
    private final Socket socket;

    public HiloServidor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(BufferedReader lector = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(),true)
        ){
            String mensaje;
            while ( (mensaje = lector.readLine()) != null)
                escritor.println("Eco " + "("+Thread.currentThread().getName()+")" + mensaje);


        } catch (IOException e) {
            System.out.println("Error con cliente: "+e.getMessage());
        }finally {
            try{
                socket.close();
                System.out.println("Cliente desconectado: " + socket.getRemoteSocketAddress());
            }catch (IOException e){
                System.out.println("Error cerrando socket: " + e.getMessage());
            }
        }
    }
}
