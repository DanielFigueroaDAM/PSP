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
        synchronized (lock){

            switch (fase) {
                case 1:
                    cogerPieza();
                    break;
                case 2:
                    pintarPieza();
                    break;
                case 3:
                    embalandoPieza();
                    break;
            }

        }
    }

    public void cogerPieza(){
        synchronized (lock) {
            try {
                System.out.println("Cogiendo pieza");
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            fase++;
        }
    }
    public void pintarPieza(){
        synchronized (lock) {
            try {
                System.out.println("Pintando la pieza");
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            fase++;
        }
    }
    public void embalandoPieza(){
        synchronized (lock) {
            try {
                System.out.println("Embalando la pieza");
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        fase++;
    }
}
