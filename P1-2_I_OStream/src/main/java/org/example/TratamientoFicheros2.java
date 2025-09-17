package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TratamientoFicheros2 {
    /**
     * Escribe el contenido de un fichero en otro fichero, sutituyendo el contenido del fichero destino
     * byte a byte.
     * @param ficheroOrigen
     * @param ficheroDestino
     */
    public static void escribirFicheroAFichero(String ficheroOrigen, String ficheroDestino) {
        try {
            File fOrigen = new File(ficheroOrigen);
            File fDestino = new File(ficheroDestino);
            FileInputStream origen = new FileInputStream(fOrigen);
            FileOutputStream destino = new FileOutputStream(fDestino);
            int byteLeido;
            while ((byteLeido = origen.read()) != -1){
                destino.write(byteLeido);
            }
            origen.close();
            destino.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Añade el contenido de un fichero al final de otro fichero, byte a byte.
     * @param ficheroOrigen
     * @param ficheroDestino
     */
    public static void añadirFicheroAFichero(String ficheroOrigen, String ficheroDestino) {
        try{
            File fOrigen = new File(ficheroOrigen);
            File fDestino = new File(ficheroDestino);
            FileInputStream origen = new FileInputStream(fOrigen);
            FileOutputStream destino = new FileOutputStream(fDestino, true);
            int byteLeido;
            while ((byteLeido = origen.read()) != -1) {
                destino.write(byteLeido);
            }
            origen.close();
            destino.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
}
