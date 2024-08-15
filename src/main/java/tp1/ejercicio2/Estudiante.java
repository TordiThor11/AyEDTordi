package tp1.ejercicio2;

public class Estudiante {
    private String apellido;
    private String nombre;
    private int legajo;

    public Estudiante(String apellido, String nombre, int legajo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.legajo = legajo;
    }
    public String getApellido(){
        return this.apellido;
    }
}
