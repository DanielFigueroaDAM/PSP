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

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("https://api.coinlore.net/api/tickers/"))
                .GET()
                .build();

        HttpResponse<String> res = null;
        try {
            res = client.send(req, HttpResponse.BodyHandlers.ofString());


            ObjectMapper mapper = new ObjectMapper();



            CoinLista miLista = mapper.readValue(res.body(), CoinLista.class);

            CriptoCoin miMoneda =(CriptoCoin) miLista
                    .getData()
                    .stream()
                    .filter( c -> c.getNombre()
                            .equalsIgnoreCase(moneda) || c.getSimbolo().equalsIgnoreCase(moneda)).findFirst().orElse(null);

            System.out.println("Nombre: " + miMoneda.getNombre());
            System.out.println("Simbolo: " + miMoneda.getSimbolo());
            System.out.println("Precio USD: " + miMoneda.getPrecioUSD());
            System.out.println("Rank: " + miMoneda.getRank());
            System.out.println("Cambio 24h: " + miMoneda.getPrecentChange24h() + "%");
        } catch (IOException e) {
            System.out.println("Error en la comunicación: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("La operación fue interrumpida: " + e.getMessage());
        }
    }
}
