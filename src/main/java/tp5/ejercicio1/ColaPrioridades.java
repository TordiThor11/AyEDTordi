package tp5.ejercicio1;

public interface ColaPrioridades<T> {

    boolean esVacia();

    boolean eliminar();

    boolean agregar(T dato);

    T tope();
}
