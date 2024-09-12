package tp3.ejercicio3;

import tp1.ejercicio2.ListaEnlazadaGenerica;
import tp3.libs.ArbolBinario;

public class ContadorArbol {
    private ArbolBinario<Integer> arbolBinario;

    public ContadorArbol(ArbolBinario<Integer> arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

    public tp1.ejercicio2.ListaEnlazadaGenerica<Integer> numerosParesInOrder() {//se puede resolver con una funcion aux?
        ListaEnlazadaGenerica<Integer> listaEnteros = new ListaEnlazadaGenerica<>();
        ArbolBinario<Integer> arbolAux = this.arbolBinario;
        if (arbolAux.esVacio()) {
            if (arbolAux.tieneHijoIzquierdo()) {
                this.arbolBinario = arbolAux.getHijoIzquierdo();
                listaEnteros = numerosParesInOrder();
            }
            listaEnteros.agregarFinal(arbolBinario.getDato());
            if (arbolAux.tieneHijoDerecho()) {
                this.arbolBinario = arbolAux.getHijoDerecho();
                listaEnteros = numerosParesInOrder();
            }
        }
        this.arbolBinario = arbolAux;
        return listaEnteros;
    }
//    public tp1.ejercicio2.ListaEnlazadaGenerica numerosPares();
}
