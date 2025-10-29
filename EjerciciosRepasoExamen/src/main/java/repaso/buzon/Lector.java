package repaso.buzon;

public class Lector extends Thread{
    private Buzon buzon;
    private Object candado;

    public Lector(Buzon buzon, Object lock) {
        this.buzon = buzon;
        candado = lock;
    }

    @Override
    public void run() {
        leerEnElBuzon();
    }
    public void leerEnElBuzon(){
        synchronized (candado){
            while (buzon.getMensaje().equals("")){
                try {
                    candado.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(buzon.getMensaje());
            buzon.setMensaje("");
            candado.notifyAll();
        }
    }
}
