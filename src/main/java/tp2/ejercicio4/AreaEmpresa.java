package tp2.ejercicio4;

public class AreaEmpresa {
    private String nombre;
    private int tardanzaDeTransmision;

    public AreaEmpresa(String nombre, int tardanzaDeTransmision) {
        this.nombre = nombre;
        this.tardanzaDeTransmision = tardanzaDeTransmision;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTardanzaDeTransmision() {
        return tardanzaDeTransmision;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "; Tardanza: " + tardanzaDeTransmision;
    }
}
