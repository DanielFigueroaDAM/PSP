package repaso.buzon;

public class Buzon {
    String mensaje;

    public Buzon() {
        this.mensaje = "";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Buzon{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }
}
