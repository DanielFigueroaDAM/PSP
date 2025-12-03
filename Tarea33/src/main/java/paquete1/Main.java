package paquete1;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HttpClient cliente = HttpClient.newHttpClient();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la URL a la que desea conectarse:");
        String url = scanner.nextLine();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();
        try {
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Código de estado: " + response.statusCode());
            System.out.println("Tipo de contenido: "+  response.headers().firstValue("Content-Type").orElse("Desconocido"));
        }catch (Exception e){
            System.out.println( "Error al realizar la solicitud HTTP: " + e.getMessage());
        }
    }
}
