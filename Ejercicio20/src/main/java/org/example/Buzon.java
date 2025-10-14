package org.example;

public class Buzon {
    private String mensaje;

    public void vaciarMensaje(){
        mensaje = "";
    }
    public void escribirMensaje(String mensaje){
        this.mensaje = mensaje;
    }
    public String leerMensaje(){
        return mensaje;
    }

    public boolean estaVacio(){
        return mensaje.equals("");
    }
}
