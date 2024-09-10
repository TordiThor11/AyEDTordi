package tp3.libs;

import tp1.ejercicio3.ColaGenerica;

public class ArbolBinario<T> {
    private T dato;
    private ArbolBinario<T> hijoIzquierdo;
    private ArbolBinario<T> hijoDerecho;


    public ArbolBinario() {
        super();
    }

    public ArbolBinario(T dato) {
        this.dato = dato;
    }

    /*
     * getters y setters
     *
     */
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Preguntar antes de invocar si tieneHijoIzquierdo()
     *
     * @return
     */
    public ArbolBinario<T> getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public ArbolBinario<T> getHijoDerecho() {
        return this.hijoDerecho;

    }

    public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
        this.hijoIzquierdo = hijo;
    }

    public void agregarHijoDerecho(ArbolBinario<T> hijo) {
        this.hijoDerecho = hijo;
    }

    public void eliminarHijoIzquierdo() {
        this.hijoIzquierdo = null;
    }

    public void eliminarHijoDerecho() {
        this.hijoDerecho = null;
    }

    public boolean esVacio() {
        return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
    }

    public boolean esHoja() {
        return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

    }

    @Override
    public String toString() {
        return this.getDato().toString();
    }


    public boolean tieneHijoIzquierdo() {
        return this.hijoIzquierdo != null;
    }


    public boolean tieneHijoDerecho() {
        return this.hijoDerecho != null;
    }

    public int contarHojas() {
        ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
        int contadorHojas = 0;
        cola.encolar(this);
        while (!cola.esVacia()) {
            var nodo = cola.desencolar();
            if (nodo.esHoja()) {
                contadorHojas++;
            } else {
                if (nodo.tieneHijoIzquierdo()) {
                    cola.encolar(nodo.getHijoIzquierdo());
                }
                if (nodo.tieneHijoDerecho()) {
                    cola.encolar(nodo.getHijoDerecho());
                }
            }
        }
        return contadorHojas;
    }


    public ArbolBinario<T> espejo() {

        return null;
    }


    public void entreNiveles(int n, int m) {

    }


}
