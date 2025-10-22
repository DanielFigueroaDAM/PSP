package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Object cand = new Object();
        Torno t1 = new Torno(cand,1000);
        Torno t2 = new Torno(cand,1000);
        Torno t3 = new Torno(cand,1000);
        Torno t4 = new Torno(cand,1000);
        t1.start();
        t2.start();
        t3.start();
        t4.start();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(ContadorPersonas.devolverContador());
    }
}
