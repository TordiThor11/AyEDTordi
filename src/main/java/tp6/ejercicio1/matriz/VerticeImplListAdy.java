package tp6.ejercicio1.matriz;

import tp6.interfaces.Vertice;

public class VerticeImplListAdy<T> implements Vertice<T> {
    private T dato;
    private int posicion;

    public VerticeImplListAdy(T dato) {
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

    @Override
    public String toString() {
        return "VerticeImplMatrizAdy{" +
                "dato=" + dato +
                ", posicion=" + posicion +
                '}';
    }
}
