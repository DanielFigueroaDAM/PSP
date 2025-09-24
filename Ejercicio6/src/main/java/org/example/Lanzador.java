package org.example;

public class Lanzador {

    static boolean esWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
    public static void llamada(){
        String ip = "";

        while (!ip.equals("salir")) {
            ip = Interfaz.pedirIP();
            ProcessBuilder procesoB = new ProcessBuilder();
            String[] comando = new String[5];
            if (esWindows) {
                comando = new String[] {"cmd", "/c", "ping", "-n", "4", ip};
            } else {
                comando = new String[] {"ping", "-c", "4", ip};
            }
            procesoB.command(comando);
            procesoB.inheritIO();
            try {
                Process proceso = procesoB.start();
                proceso.waitFor();
            } catch (Exception e) {
                System.out.println("Error en la ejecucion del comando" + e.getMessage());
            }


        }
    }
}
