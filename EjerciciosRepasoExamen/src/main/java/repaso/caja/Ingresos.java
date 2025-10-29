package repaso.caja;
//Hilo de ingresos: Simula 5.000 ventas, sumando 10€ a la caja por cada venta.
public class Ingresos extends Thread{
    private int ventas;
    private double cantidadEuros;
    private Object candado;

    public Ingresos(int ventas, double cantidadEuros, Object candado) {
        this.ventas = ventas;
        this.cantidadEuros = cantidadEuros;
        this.candado = candado;
    }

    @Override
    public void run() {
        for (int i=0;i<ventas;i++){
            synchronized (candado) {
                Caja.capital += cantidadEuros;
            }
        }
    }
}
