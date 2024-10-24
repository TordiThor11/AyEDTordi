package tp6.ejercicio1;

import tp6.interfaces.Vertice;

public class VerticeImplMatrizAdy<T> implements Vertice<T> {
    private T dato;
    private int posicion;

    public VerticeImplMatrizAdy(T dato) {
        this.dato = dato;
    }

    @Override
    public T dato() {
        return this.dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
