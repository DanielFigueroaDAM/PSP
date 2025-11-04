package com.supermercado;

public class CajaDinero {
    private static int dinero;

    public static int getDinero() {
        return dinero;
    }

    public static void aumentarDinero(int dineroAnadido) {
        dinero += dineroAnadido;
    }
}
