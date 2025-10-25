package repaso.parking;


public class Parking {
    private int[] plazas;
    public Parking(int[] plazas) {
        this.plazas = plazas;
    }

    public int[] getPlazas() {
        return plazas;
    }
    public void setPlazas(int[] plazas) {
        this.plazas = plazas;
    }
    public void meterEnPlaza(int coche){
        for(int i = 0 ; i<plazas.length;i++){
            if(plazas[i] == 0) {
                plazas[i] = coche;
                break;
            }
        }
    }
    public boolean hayPlazaLibre(){
        for(int i = 0 ; i<plazas.length;i++){
            if(plazas[i] == 0)
                return true;
        }
        return false;
    }
    public void vacioDeParking(int numeroCoche){
        for(int i = 0;i<plazas.length;i++){
            if(plazas[i] == numeroCoche){
                plazas[i]=0;
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder plazasString = new StringBuilder();
        for (int plaza :this.plazas){
            plazasString.append(" ["+plaza+"] ");
        }
        return plazasString.toString();
    }
}
