package org.example;


public class Main extends Thread {
    static int n = 14;
    public static void main(String[] args) {
        Main thread = new Main();
        thread.start();

    }

    @Override
    public void run() {
        int n1 =0, n2=1, fibonacci=0;
        System.out.print(n1 + " " + n2);
        for(int i=2; i<n; i++) {
            fibonacci = n1 + n2;
            System.out.print(" " + fibonacci);
            n1 = n2;
            n2 = fibonacci;
        }
    }
}