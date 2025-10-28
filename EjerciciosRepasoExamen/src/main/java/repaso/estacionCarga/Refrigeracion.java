package repaso.estacionCarga;

public class Refrigeracion {
    private static Cargador [] idCargadores = {null,null};

    public static Cargador[] getIdCargadores() {
        return idCargadores;
    }

    public static void setIdCargadores(Cargador[] idCargadoresInsertado) {
        idCargadores = idCargadoresInsertado;
    }

    public static void refrigerarCargador(Cargador cargadorParaRefrigerar){
        for(int i = 0;i<idCargadores.length;i++){
            if(idCargadores[i] == null){
                idCargadores[i] =cargadorParaRefrigerar;
            }
        }
        try {
            System.out.println("Refrigerando el cargador"+cargadorParaRefrigerar.getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean hayHueco(){
        if(idCargadores[0] == null || idCargadores[1] == null){
            return true;
        }
        return false;
    }

}
