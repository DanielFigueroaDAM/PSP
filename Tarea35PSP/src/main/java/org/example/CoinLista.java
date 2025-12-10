package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinLista {
    private List<CriptoCoin> data;

    public List<CriptoCoin> getData() {
        return data;
    }

    public void setData(List<CriptoCoin> data) {
        this.data = data;
    }
}
