package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        boolean continuar;
        HttpRequest request1 = null;
        HttpRequest request2 = null;
        HttpClient cliente = null;
        // Solicitar las dos URLs al usuario, asegurándose de que sean válidas
        do {
            continuar = true;
            try {
                System.out.println("Ingrese la Primera URL a la que desea conectarse:");
                String url1 = tec.nextLine();
                System.out.println("Ingrese la Segunda URL a la que desea conectarse:");
                String url2 = tec.nextLine();
                cliente = HttpClient.newHttpClient();

                request1 = HttpRequest.newBuilder()
                        .uri(URI.create(url1))
                        .timeout(Duration.ofSeconds(10))
                        .GET()
                        .build();
                request2 = HttpRequest.newBuilder()
                        .uri(URI.create(url2))
                        .timeout(Duration.ofSeconds(10))
                        .GET()
                        .build();

            }catch ( Exception e){
                System.out.println( "Error al realizar la solicitud HTTP o URL inválida: " + e.getMessage());
                System.out.println("Por favor, ingrese las URLs nuevamente.");
                continuar = false;
            }
        } while (!continuar);

        try{
            // Medimos el tiempo de respuesta de ambas solicitudes
            long start1 = System.nanoTime();
            HttpResponse<byte[]> response1 = cliente.send(request1, HttpResponse.BodyHandlers.ofByteArray());
            long time1 = System.nanoTime() - start1;

            long start2 = System.nanoTime();
            HttpResponse<byte[]> response2 = cliente.send(request2, HttpResponse.BodyHandlers.ofByteArray());
            long time2 = System.nanoTime() - start2;

            //Obtener la códificacion
            String contentType1 = response1.headers()
                    .firstValue("Content-Type")
                    .orElse("");

            String contentType2 = response2.headers()
                    .firstValue("Content-Type")
                    .orElse("");

            // Obtener la codificación de cada respuesta
            Charset charset1 = getCharset(contentType1);
            Charset charset2 = getCharset(contentType2);

            // Operador ternario para comprobar si el cuerpo es nulo
            //creamos el string a partir del array de bytes pasandole la codificación
            String body1 = response1.body() != null ? new String(response1.body(), charset1) : "";
            String body2 = response2.body() != null ? new String(response2.body(), charset2) : "";
            /*
            Tenemos que usar codePointCount en lugar de length para contar correctamente los caracteres Unicode que pueden ocupar más de un byte
            (por ejemplo, emojis o caracteres de ciertos idiomas).
             */
            int size1 = body1.codePointCount(0, body1.length());
            int size2 = body2.codePointCount(0, body2.length());

            // Guardamos las URLs como Strings para mostrarlas después
            String r1String = request1.uri().toString();
            String r2String = request2.uri().toString();

            String webMasRapida = time1 < time2 ? r1String : r2String; // si time1 es menor que time2, elegir request1, si no, request2
            long mejorTiempo = Math.min(time1, time2); // clase Math para obtener el mínimo

            String webMasContenido = size1 > size2 ? r1String : r2String; // con request1.uri().toString() obtener la URL en formato String
            long mejorTamanyo = Math.max(size1, size2); // clase Math para obtener el máximo


            System.out.println();
            System.out.println("La web más rápida es: " + webMasRapida + " con un tiempo de respuesta de " + (mejorTiempo/1_000_000.0) + " ms");
            System.out.println("La web con más contenido es: " + webMasContenido + " con " + mejorTamanyo + " caracteres.");

        } catch (InterruptedException | IOException e) {
            System.out.println( "Error al realizar la solicitud HTTP: " + e.getMessage());
        }

        tec.close();
    }

    /**
     * Obtiene la codificación de caracteres a partir del encabezado Content-Type.
     * @param contentType
     * @return
     */
    private static Charset getCharset(String contentType){
        if (contentType.contains("charset=")) {
            try {
                String charsetValue = contentType
                        .substring(contentType.indexOf("charset=") + 8)
                        .split(";")[0]      // evitar "UTF-8; algo"
                        .trim();

                return  Charset.forName(charsetValue);
            } catch (Exception e) {
                System.out.println("Codificación no reconocida, se usará UTF-8 por defecto.");
                return  StandardCharsets.UTF_8;
            }
        }
        return StandardCharsets.UTF_8;
    }
}