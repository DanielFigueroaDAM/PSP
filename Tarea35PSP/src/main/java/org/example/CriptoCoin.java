package org.example;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase que representa una criptomoneda con sus propiedades.
 * @JsonIgnoreProperties(ignoreUnknown = true) indica que se ignoren las propiedades desconocidas durante la deserialización JSON.
 * @JsonProperty se utiliza para mapear los nombres de las propiedades JSON a los nombres de los campos de la clase.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CriptoCoin {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("symbol")
    private String simbolo;
    @JsonProperty("price_usd")
    private String precioUSD;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("percent_change_24h")
    private double precentChange24h;

    public CriptoCoin() {
    }

    public CriptoCoin(String nombre, String simbolo, String precioUSD, int rank, int precentChange24h) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.precioUSD = precioUSD;
        this.rank = rank;
        this.precentChange24h = precentChange24h;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getPrecioUSD() {
        return precioUSD;
    }

    public void setPrecioUSD(String precioUSD) {
        this.precioUSD = precioUSD;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getPrecentChange24h() {
        return precentChange24h;
    }

    public void setPrecentChange24h(double precentChange24h) {
        this.precentChange24h = precentChange24h;
    }

    @Override
    public String toString() {
        return "CriptoCoin{" +
                "nombre='" + nombre + '\'' +
                ", simbolo='" + simbolo + '\'' +
                ", precioUSD=" + precioUSD +
                ", rank=" + rank +
                ", precentChange24h=" + precentChange24h +
                '}';
    }
}
