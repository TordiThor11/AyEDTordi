package tp1.ejercicio2;

import java.sql.Array;

public class TestListaEnlazadaGenerica {
    public static <T> void main(String[] args) {
        var listaGenerica = new ListaEnlazadaGenerica<>();
        listaGenerica.comenzar();

//        listaGenerica.agregarFinal(new Estudiante("gomez", "jose", 12312));
//        listaGenerica.agregarFinal(new Estudiante("gonzales", "luana", 14256));
//        listaGenerica.agregarFinal(new Estudiante("perez", "catalina", 92421));
//        listaGenerica.agregarFinal(new Estudiante("martinez", "matias", 18745));

        System.out.println(listaGenerica.toString());
        for (int i = 0; i < listaGenerica.tamanio(); i++) {
            Estudiante elementoGenerico = (Estudiante) listaGenerica.elemento(i+1);
            System.out.println(elementoGenerico.getApellido());
        }       //Se transforma en object, si o si tengo que castearlo manual?

        //Test del punto 2.4.d
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[4];    //Tiene que crearse la cantidad justa, todavia no lo termine.
        array[0] = (T) new Estudiante("gomez", "jose", 12312);
        array[1] = (T) new Estudiante("gonzales", "luana", 14256);
        array[2] = (T) new Estudiante("perez", "catalina", 92422);
        listaGenerica.agregar(array);
        System.out.println(listaGenerica.toString());
    }
}
