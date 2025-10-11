package org.example;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Monitor extends Thread{
    /*
    Ejercicio 2: Monitor de Recursos del Sistema
        Enunciado: Desarrolla una aplicación que monitoree en tiempo real:
            Uso de memoria (total, libre, usada)
            Número de hilos activos
            Uso de CPU aproximado
            Muestra esta información actualizada cada segundo durante 30 segundos.
     */
    @Override
    public void run() {
        while (true){
            String memorias = usoMemoria();
            String numeroHilosActivos = numHilos();
            String usoCPU = usoCPUAprox();
            System.out.println(memorias);
            System.out.println(numeroHilosActivos);
            System.out.println(usoCPU);
            try {
                Thread.currentThread().sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static String usoMemoria(){
        Runtime p = Runtime.getRuntime();
        return "Memoria Usada -> "+ (p.totalMemory()-p.freeMemory())+", Memoria total -> "+p.totalMemory()+", Memoria libre -> "+p.freeMemory();
    }
    public static String numHilos(){
        return "Numero de hilos -> "+currentThread().activeCount();
    }
    public static String usoCPUAprox(){
        String command = "bash -c 'top -bn1 | grep \"Cpu(s)\" | awk \"{print $2 + $4}\"'";

        try {
            // 1. Ejecutar el proceso
            Process process = Runtime.getRuntime().exec(command);

            // 2. Esperar a que el proceso termine (aunque no es estrictamente necesario, es buena práctica)
            // process.waitFor();

            // 3. Leer la salida del comando
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line = reader.readLine();

            if (line != null) {
                // 4. La salida es un porcentaje (ej. 5.5). Lo dividimos por 100 para tener un factor (ej. 0.055)
                double cpuLoadPercent = Double.parseDouble(line.trim());
                double cpuLoadFactor = cpuLoadPercent / 100.0;

                // Usamos String.format para mostrarlo con buena precisión.
                return "La CPu etimada (Nativa) es " + String.format("%.4f", cpuLoadFactor);
            }

        } catch (Exception e) {
            // Manejo de errores si el comando falla (p. ej., si el SO cambia o el comando no existe)
            System.err.println("Error al obtener la CPU nativamente.");
            // e.printStackTrace();
            return "La CPu etimada (Nativa) es Error";
        }
        return "La CPu etimada (Nativa) es 0.0";
    }




}
