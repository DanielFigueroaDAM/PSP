package repaso.parking;

public class App {
    private static final Object lock = new Object();
    public static void main(String[] args) {
        int[] plazas = new int[5];
        Parking miParking = new Parking(plazas);
        System.out.println(miParking);
        Object lock = new Object();
        Coche c1 = new Coche(lock,1,miParking);
        Coche c2 = new Coche(lock,2,miParking);
        Coche c3 = new Coche(lock,3,miParking);
        Coche c4 = new Coche(lock,4,miParking);
        Coche c5 = new Coche(lock,5,miParking);
        Coche c6 = new Coche(lock,6,miParking);
        Coche c7 = new Coche(lock,7,miParking);
        Coche c8 = new Coche(lock,8,miParking);

        c1.start(); c2.start();c3.start(); c4.start();c5.start(); c6.start();c7.start(); c8.start();
        try {
            c1.join();c2.join();c3.join(); c4.join();c5.join(); c6.join();c7.join(); c8.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
