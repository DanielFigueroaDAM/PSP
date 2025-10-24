package repaso.enunciadoR1;

public class Torno extends Thread{
    private Object lock;

    public Torno(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 0;i<1000;i++) {
            synchronized (this.lock) {
                Entradas.aumentarEntradas();
            }
        }
    }
}
