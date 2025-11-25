package maquina2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9000);
            boolean recibiendo = true;
            ArrayList<String> mensajes = new ArrayList<>();

            InetAddress lastAddress = null;
            int lastPort = -1;
            while (recibiendo) {
                byte[] bufferRecepcion = new byte[1024];
                DatagramPacket paquete = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);
                socket.receive(paquete);

                String msg = new String(paquete.getData(), 0, paquete.getLength(), StandardCharsets.UTF_8);
                lastAddress = paquete.getAddress();
                lastPort = paquete.getPort();

                if (msg.equals("end")) { // seguro hay alguna manera más sofisticada de hacerlo
                    recibiendo = false;
                } else {
                    mensajes.add(msg);
                    System.out.println("Mensaje guardado: " + msg);
                }
            }

            // Devolver la palabra más larga al cliente (si hay alguno conocido)
            String mensajeMasLargo = mensajes.stream()
                    .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                    .orElse("");

            if (lastAddress == null || lastPort == -1) {
                System.out.println("No se conoce cliente para enviar la respuesta.");
            } else {
                byte[] bufferEnvio = mensajeMasLargo.getBytes(StandardCharsets.UTF_8);
                DatagramPacket paqueteEnvio = new DatagramPacket(
                        bufferEnvio,
                        bufferEnvio.length,
                        lastAddress,
                        lastPort
                );
                socket.send(paqueteEnvio);
                System.out.println("Enviado mensaje mas largo: '" + mensajeMasLargo + "' a " + lastAddress + ":" + lastPort);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
