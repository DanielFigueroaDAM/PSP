package repaso.estacionCarga;

public class Vehiculo extends Thread{
    private Object candado;
    private int coche;

    public Vehiculo(Object candado, int coche) {
        this.candado = candado;
        this.coche = coche;
    }

    public int getCoche() {
        return coche;
    }

    public void setCoche(int coche) {
        this.coche = coche;
    }
}
