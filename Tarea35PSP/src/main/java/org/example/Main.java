package org.example;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        String moneda = JOptionPane.showInputDialog("Ingrese la Cripto Moneda que deseas ver la información");

        HttpClient client = HttpClient.newHttpClient();
        // Construimos la petición HTTP
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("https://api.coinlore.net/api/tickers/"))
                .GET()
                .build();

        HttpResponse<String> res = null;
        try {
            res = client.send(req, HttpResponse.BodyHandlers.ofString());


            ObjectMapper mapper = new ObjectMapper();



            CoinLista miLista = mapper.readValue(res.body(), CoinLista.class);
            // Con la lista de monedas que está dentro de mi CoinLista filtramos según el nombre o el símbolo, en el caso de que coincida devolvemos un null
            CriptoCoin miMoneda =(CriptoCoin) miLista
                    .getData()
                    .stream()
                    .filter( c -> c.getNombre()
                            .equalsIgnoreCase(moneda) || c.getSimbolo().equalsIgnoreCase(moneda)).findFirst().orElse(null);
            // Si no se encuentra la moneda, lanzamos una excepción
            if (miMoneda == null) {
                throw new IllegalArgumentException("Moneda no encontrada.");
            }
            System.out.println("Nombre: " + miMoneda.getNombre());
            System.out.println("Simbolo: " + miMoneda.getSimbolo());
            System.out.println("Precio USD: " + miMoneda.getPrecioUSD());
            System.out.println("Rank: " + miMoneda.getRank());
            // Obtener el cambio porcentual en 24h
            double precentChange24h = miMoneda.getPrecentChange24h();

            // Colores ANSI
            final String RESET = "\u001B[0m";
            final String RED = "\u001B[31m";
            final String GREEN = "\u001B[32m";
            final String YELLOW = "\u001B[33m";
            final String BLUE = "\u001B[34m";

            if (precentChange24h < 0 && precentChange24h > -10) {
                // Amarillo
                System.out.println(YELLOW + "La moneda ha bajado poco en las últimas 24 horas: "
                        + precentChange24h + "%" + RESET);

            } else if (precentChange24h <= -10) {
                // Rojo
                System.out.println(RED + "La moneda ha bajado mucho en las últimas 24 horas: "
                        + precentChange24h + "%" + RESET);

            } else if (precentChange24h > 0 && precentChange24h < 10) {
                // Azul
                System.out.println(BLUE + "La moneda ha subido poco en las últimas 24 horas: "
                        + precentChange24h + "%" + RESET);

            } else {
                // Verde
                System.out.println(GREEN + "La moneda ha subido mucho en las últimas 24 horas: "
                        + precentChange24h + "%" + RESET);
            }

        } catch (IOException e) {
            System.out.println("Error en la comunicación: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("La operación fue interrumpida: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
