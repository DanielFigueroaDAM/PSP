package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(()->sumar(1));
        Thread hilo2 = new Thread(()->sumar(2));
        Thread hilo3 = new Thread(()->sumar(3));
        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
    public static void sumar(int a){
        switch (a){
            case 1:
                int suma1=0;
                for (int i=1;i<=1923;i++){
                    if(i%2==0){ //es par
                        suma1+=i;
                    }
                }
                System.out.println("La suma del hilo 1 es: "+suma1);
                break;
            case 2:
                int suma2=0;
                for (int i=1;i<=1923;i++){
                    if(i%2==1){ //es impar
                        suma2+=i;
                    }
                }
                System.out.println("La suma del hilo 2 es: "+suma2);
                break;

            case 3:
                Integer suma3 = 0;
                for (Integer i=1;i<=1923;i++){
                    String numString =i.toString();
                    if(numString.charAt(numString.length()-1)=='3')
                        suma3+=i;
                    else if(numString.charAt(numString.length()-1)=='4')
                        suma3+=i;

                }
                System.out.println("La suma del hilo 3 es: "+suma3);
                break;
        }

    }

}