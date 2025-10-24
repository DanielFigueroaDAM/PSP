package repaso.enunciadoR1;

public class Entradas {
    private static Integer entradasTotal=0;
    public static Integer getEntradasTotales(){
        return entradasTotal;
    }
    public static void aumentarEntradas(){
        entradasTotal++;
    }

}
