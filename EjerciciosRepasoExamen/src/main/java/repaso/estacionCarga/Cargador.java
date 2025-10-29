package repaso.estacionCarga;

public class Cargador extends Thread{
    private Object candado;
    private Vehiculo vehiculoParaReparar;
    private boolean estaRefrigerado;

    public Cargador(Object candado, Vehiculo vehiculo) {
        this.candado = candado;
        this.vehiculoParaReparar = vehiculo;
    }

    @Override
    public void run() {
        synchronized (candado) {
            while (!estaRefrigerado) {
                try {
                    candado.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public Vehiculo getVehiculoParaReparar() {
        return vehiculoParaReparar;
    }

    public void setVehiculoParaReparar(Vehiculo vehiculoParaReparar) {
        this.vehiculoParaReparar = vehiculoParaReparar;
    }
}
