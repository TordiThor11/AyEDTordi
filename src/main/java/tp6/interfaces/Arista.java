package tp6.interfaces;

/**
 * Representa una arista de un {@link Grafo}
 */
public interface Arista<T> {

    public Vertice<T> verticeDestino();

    public int peso();

}
