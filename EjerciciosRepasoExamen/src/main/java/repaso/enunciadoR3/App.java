package repaso.enunciadoR3;

public class App {
    private static Buzon b1 = new Buzon(false);
    private static Object o = new Object();
    public static void main(String[] args) {

        Thread cliente = new Thread(App::recogerPaquete);
        Thread repartidor = new Thread(App::depositarPaquete);
        cliente.start();
        repartidor.start();

    }
    public static void recogerPaquete(){
        synchronized (o) {
            while (!b1.isEstaLleno()) {
                try {
                    System.out.println("esperando a que dejen el paquete");
                    o.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            b1.setEstaLleno(false);
            System.out.println("Paquete recogido");
        }
    }
    public static void depositarPaquete(){
        synchronized (o) {
            try {
                Thread.sleep((long)(Math.random() * 4000 + 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            b1.setEstaLleno(true);
            o.notifyAll();
            System.out.println("paquete depositado");
        }
    }
}
