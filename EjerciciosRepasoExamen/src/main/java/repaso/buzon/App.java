package repaso.buzon;

public class App {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Buzon b1 = new Buzon();
        Escritor e1 = new Escritor("hola1", b1, lock);
        Escritor e2 = new Escritor("hola2", b1, lock);
        Escritor e3 = new Escritor("hola3", b1, lock);
        Escritor e4 = new Escritor("hola4", b1, lock);
        Escritor e5 = new Escritor("hola5", b1, lock);
        Escritor e6 = new Escritor("hola6", b1, lock);
        Escritor e7 = new Escritor("hola7", b1, lock);
        Escritor e8 = new Escritor("hola8", b1, lock);
        Lector l1 = new Lector(b1, lock);
        Lector l2 = new Lector(b1, lock);
        Lector l3 = new Lector(b1, lock);
        Lector l4 = new Lector(b1, lock);
        Lector l5 = new Lector(b1, lock);
        Lector l6 = new Lector(b1, lock);
        Lector l7 = new Lector(b1, lock);
        Lector l8 = new Lector(b1, lock);
        e1.start();
        e2.start();
        e3.start();
        e4.start();
        e5.start();
        e6.start();
        e7.start();
        e8.start();
        l1.start();
        l2.start();
        l3.start();
        l4.start();
        l5.start();
        l6.start();
        l7.start();
        l8.start();
        try {


            e1.join();
            e2.join();
            e3.join();
            e4.join();
            e5.join();
            e6.join();
            e7.join();
            e8.join();
            l1.join();
            l2.join();
            l3.join();
            l4.join();
            l5.join();
            l6.join();
            l7.join();
            l8.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}