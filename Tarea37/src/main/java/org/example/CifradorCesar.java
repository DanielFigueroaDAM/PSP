package org.example;

public class CifradorCesar {
    private String texto;
    private int desplazamiento;

    public CifradorCesar(String texto, int desplazamiento) {
        this.texto = texto.toLowerCase();
        this.desplazamiento = desplazamiento;
    }

    public String cifrar(){
        StringBuilder mensajeCifrado = new StringBuilder();
        for(int i = 0; i<texto.length();i++){
            char nuevoCaracter=texto.charAt(i);
            nuevoCaracter += (char) desplazamiento;
            nuevoCaracter = cifradoRecursivo(nuevoCaracter);
            if(nuevoCaracter<97){
                nuevoCaracter = (char)((nuevoCaracter+97));
            }
            mensajeCifrado.append(nuevoCaracter);
        }
        return mensajeCifrado.toString();
    }

    private char cifradoRecursivo(char miCaracter){
        if(miCaracter>122){
            miCaracter = cifradoRecursivo((char)(miCaracter%122));
        }
        return miCaracter;
    }


}


