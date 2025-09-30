package org.example;

import java.text.Format;

import static java.lang.String.format;

public class Profesor extends Thread{
    private String nombre;
    private int nivelPaciencia;

    public Profesor(String nombre, int nivelPaciencia) {
        this.nombre = nombre;
        this.nivelPaciencia = nivelPaciencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelPaciencia() {
        return nivelPaciencia;
    }

    public void setNivelPaciencia(int nivelPaciencia) {
        this.nivelPaciencia = nivelPaciencia;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", nivelPaciencia=" + nivelPaciencia +
                '}';
    }
    @Override
    public void run() {
        int trabajosConIa = 0;
        while(trabajosConIa < nivelPaciencia){
            if (esIA()){
                trabajosConIa++;
                System.out.println(format( "[%s] Cabreo del profesor: %d", nombre, trabajosConIa) );
            }
        }
        System.out.println(format( "[%s] El profesor ha perdido la paciencia y ha explotado", nombre) );
    }
    public boolean esIA(){
        return Math.random() < 0.5;
    }

}
