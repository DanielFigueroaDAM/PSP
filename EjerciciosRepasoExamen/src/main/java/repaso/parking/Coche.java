package repaso.parking;

public class Coche extends Thread{
    private Object lock;
    private int numeroCoche;
    private Parking p;

    public Coche(Object lock, int numeroCoche, Parking p) {
        this.lock = lock;
        this.numeroCoche = numeroCoche;
        this.p = p;
    }

    @Override
    public void run() {
        entrarEnParking();
    }

    private void entrarEnParking() {
        synchronized (lock) {
            while (!p.hayPlazaLibre()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("[coche: "+numeroCoche+"]Esperando por plaza libre \n"+p);
            }
            p.meterEnPlaza(numeroCoche);
            lock.notifyAll();
            System.out.println("Consiguio plaza el coche "+numeroCoche+"\n"+p);
        }

        try {
            Thread.sleep((int)(Math.random() * 5000 + 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        salirDeParking();
    }

    public void salirDeParking(){
        synchronized (lock){
            p.vacioDeParking(numeroCoche);
            System.out.println("El coche "+ numeroCoche +" abandonó la plaza: \n"+p);
            lock.notifyAll();
        }
        try {
            Thread.sleep((int)(Math.random() * 5000 + 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        entrarEnParking();

    }
}
