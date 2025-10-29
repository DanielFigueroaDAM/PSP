package repaso.caja;

public class App {
    public static void main(String[] args) {
        Object candado = new Object();
        Extracciones extractor = new Extracciones(3000,10,candado);
        Ingresos meter = new Ingresos(5000, 10, candado);
        extractor.start();
        meter.start();

        try {
            extractor.join();
            meter.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Caja.capital);
    }
}
