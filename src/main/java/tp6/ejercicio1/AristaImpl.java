package tp6.ejercicio1;

import tp6.interfaces.Arista;
import tp6.interfaces.Vertice;

public class AristaImpl<T> implements Arista<T> {
    private Vertice<T> destino;
    private int peso;

    public AristaImpl(Vertice<T> verticeDestino, int peso) {
        this.destino = verticeDestino;
        this.peso = peso;
    }

    @Override
    public Vertice<T> verticeDestino() {
        return this.destino;
    }

    @Override
    public int peso() {
        return this.peso;
    }
}
