package maquina1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Cliente {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ipDestino = InetAddress.getByName("localhost");
            String[] sendListWords = {"Hola", "que", "tal", "estas"};
            for(String word: sendListWords) {
                byte[] bufferEnvio = word.getBytes(StandardCharsets.UTF_8);
                DatagramPacket paquete = new DatagramPacket(
                        bufferEnvio,
                        bufferEnvio.length,
                        ipDestino,
                        9000
                );
                socket.send(paquete);
            }
            byte[] bufferEnvio = ("end".getBytes(StandardCharsets.UTF_8));
            DatagramPacket paquete = new DatagramPacket(
                    bufferEnvio,
                    bufferEnvio.length,
                    ipDestino,
                    9000
            );
            socket.send(paquete);
            //Recoger paquete de respuesta
            byte[] bufferRecepcion = new byte[1024];
            DatagramPacket paqueteRespuesta = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);
            socket.receive(paqueteRespuesta);
            String mensajeRespuesta = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength(), StandardCharsets.UTF_8);
            System.out.println("Mensaje recibido del servidor: " + mensajeRespuesta);
            socket.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}
