package tp6.interfaces;

/**
 * Representa una Vertice de un grafo.
 */
public interface Vertice<T> {

    public T dato();

    public void setDato(T dato);

    public int getPosicion();

}
