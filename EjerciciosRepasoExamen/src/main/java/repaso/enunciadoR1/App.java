package repaso.enunciadoR1;

/*
El Erizana ha ascendido a tercera ref y la federación de fútbol le ha exigido
controlar la asistencia total a sus partidos. Para acelerar la entrada, se instalan 4
tornos.
● Crea un programa que simule estos 4 tornos usando hilos.
● El total de espectadores es un único recurso compartido por los 4 hilos.
● Cada torno debe simular la entrada de 1.000 personas (simula la demora de
tiempo para cada entrada de cada aficionado ya que algunos no saben
pasar el carnet/entrada).
● Lanza los 4 hilos a la vez y espera a que terminen.
● Al final, el programa debe imprimir el número total de personas en el estadio
 */

public class App {
    private static final Object lock = new Object();
    public static void main(String[] args) {
        Torno t1 = new Torno(lock);
        Torno t2 = new Torno(lock);
        Torno t3 = new Torno(lock);
        Torno t4 = new Torno(lock);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join(); t2.join(); t3.join(); t4.join();
        } catch (InterruptedException e) {
            System.out.println("error al parar los hilos"+ e.getMessage());
        }
        System.out.println(Entradas.getEntradasTotales());
    }
}
