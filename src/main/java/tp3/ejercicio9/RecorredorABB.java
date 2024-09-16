package tp3.ejercicio9;

import tp1.ejercicio2.ListaEnlazadaGenerica;
import tp1.ejercicio2.ListaGenerica;
import tp3.libs.ArbolBinarioDeBusqueda;

public class RecorredorABB {

    public ListaGenerica<Integer> caminoRecorrido(ArbolBinarioDeBusqueda<Integer> abb) throws Exception {
        ListaGenerica<Integer> listaRecorridos = new ListaEnlazadaGenerica<Integer>();//guarda el recorrido del arbol, si va a la izq, el valor del nodo es negativo.
        if (abb.esVacio()) {
            throw new Exception("El arbol esta vacio");
        }
        if ()
        return listaRecorridos;
    }

}
