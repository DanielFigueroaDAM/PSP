package repaso.enunciadoR2;

public class EstadosProduccion {
    private static int faseProducto = 0;
    public static void avanzarProduccion(){
        faseProducto++;
    }
    public static int getFaseProducto(){
        return faseProducto;
    }
}
