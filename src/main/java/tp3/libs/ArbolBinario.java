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


    public ArbolBinario<T> espejo() throws Exception {
        if (this.esVacio()) {
            throw new Exception("El arbol es vacio (No tiene datos ni hijos).");
        }
        ArbolBinario<T> arbolEspejo = new ArbolBinario<T>(this.dato);
        if (!this.esHoja()) {
            if (this.tieneHijoIzquierdo()) {
                arbolEspejo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
            }
            if (this.tieneHijoDerecho()) {
                arbolEspejo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
            }

        }
        return arbolEspejo;
    }

    public void entreNiveles(int n, int m) throws Exception {
        ColaGenerica<ArbolBinario<T>> colaNodosArbol = new ColaGenerica<ArbolBinario<T>>();
        ColaGenerica<Integer> colaNiveles = new ColaGenerica<Integer>();
        colaNodosArbol.encolar(this);
        colaNiveles.encolar(0); // Encola en nivel de la raiz (0)
        while (!colaNodosArbol.esVacia()) {
            var nodo = colaNodosArbol.desencolar();
            int nivelDelNodo = colaNiveles.desencolar();
            if (0 > n) {    //Podria preguntar tambien si m > alturaDelArbol. Pero no tengo un metodo para eso. Ademas no es lo que pide.
                throw new Exception("El nivel del nodo pasado por parametro no es valido");
            }
            if (nivelDelNodo >= n && nivelDelNodo <= m) {
                System.out.println("Dato:" + nodo.dato + " ;Nivel:" + nivelDelNodo);
            }
            if (nodo.tieneHijoIzquierdo()) {
                colaNodosArbol.encolar(nodo.getHijoIzquierdo());
                colaNiveles.encolar(nivelDelNodo + 1);
            }
            if (nodo.tieneHijoDerecho()) {
                colaNodosArbol.encolar(nodo.getHijoDerecho());
                colaNiveles.encolar(nivelDelNodo + 1);
            }
        }
    }
}
