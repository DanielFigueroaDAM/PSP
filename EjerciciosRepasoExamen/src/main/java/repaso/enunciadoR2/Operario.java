package repaso.enunciadoR2;

public class Operario extends Thread{
    private Object lock;
    private int fase;
    public Operario(Object lock, int fase) {
        this.lock = lock;
        this.fase=fase;
    }

    @Override
    public void run() {
            switch (fase) {
                case 1 -> cogerPieza();
                case 2 -> pintarPieza();
                case 3 -> embalandoPieza();
            }
    }

    public void cogerPieza(){
        try {

            synchronized (lock) {
                while (EstadosProduccion.getFaseProducto() != 0) {
                    lock.wait();
                }
                System.out.println("Cogiendo pieza");
                EstadosProduccion.avanzarProduccion();
                lock.notifyAll();
            }
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void pintarPieza(){
        try {
            synchronized (lock) {
                while (EstadosProduccion.getFaseProducto() != 1) {
                    lock.wait();
                }
                System.out.println("Pintando la pieza");
                sleep(1000);
                EstadosProduccion.avanzarProduccion();
                lock.notifyAll();
            }
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void embalandoPieza(){

        try {
            synchronized (lock) {
                while (EstadosProduccion.getFaseProducto() != 2) {
                    lock.wait();
                }
                System.out.println("Embalando la pieza");
            }
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
