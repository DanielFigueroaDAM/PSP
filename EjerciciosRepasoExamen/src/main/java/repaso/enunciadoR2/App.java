package repaso.enunciadoR2;

public class App {

    public static void main(String[] args) {
        Object l1 = new Object();
        Operario o1 = new Operario(l1,1);
        Operario o2 = new Operario(l1,2);
        Operario o3 = new Operario(l1,3);

        o1.start(); o2.start(); o3.start();

        try{
            o1.join(); o2.join(); o3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
