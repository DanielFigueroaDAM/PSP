package repaso.caja;
/*


    La Caja:
    Crea una clase Caja con una variable estática para el capital inicial:
    public static double capital = 1000.0;

    Los hilos:

        Hilo de ingresos: Simula 5.000 ventas, sumando 10€ a la caja por cada venta.

        Hilo de extracciones: Simula 3.000 pagos a proveedores, restando 10€ de la caja por cada pago.

    Simulación de operaciones:
    Para cada iteración de los hilos:

        Consulta el saldo actual.

        Espera 1 ms (Thread.sleep(1)) para simular el tiempo de la operación.

        Actualiza el saldo sumando o restando 10€.

    Método principal:

        Lanza ambos hilos.

        Espera a que terminen (join()).

        Al final, muestra el saldo final de la caja por pantalla.

 */

public class Extracciones extends Thread{
    private int pagos;
    private double cantidadDinero;
    Object candado;

    public Extracciones(int pagos, double cantidadDinero, Object candado) {
        this.pagos = pagos;
        this.cantidadDinero = cantidadDinero;
        this.candado = candado;
    }


    @Override
    public void run() {
        for(int i =0; i<pagos;i++){
            synchronized (candado){
                Caja.capital -= cantidadDinero;
            }
        }
    }
}
