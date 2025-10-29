package repaso.buzon;

public class Escritor extends Thread{
    private String mensaje;
    private Buzon buzon;
    private Object candado;

    public Escritor(String mensaje, Buzon buzon, Object lock) {
        this.mensaje = mensaje;
        this.buzon = buzon;
        candado = lock;
    }

    @Override
    public void run() {
        escribirEnBuzon();
    }

    public void escribirEnBuzon(){
        synchronized (candado){
            while (!buzon.getMensaje().equals("")){
                try {
                    candado.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Mensaje insertado");
            buzon.setMensaje(mensaje);
            candado.notifyAll();
        }

    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Escritor{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }
}
