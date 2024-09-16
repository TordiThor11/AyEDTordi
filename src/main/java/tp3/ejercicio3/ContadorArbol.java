package tp3.ejercicio3;

import tp1.ejercicio2.ListaEnlazadaGenerica;
import tp3.libs.ArbolBinario;

public class ContadorArbol {
    private ArbolBinario<Integer> arbolBinario;

    public ContadorArbol(ArbolBinario<Integer> arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

    public tp1.ejercicio2.ListaEnlazadaGenerica<Integer> numerosParesInOrder() {
        ListaEnlazadaGenerica<Integer> listaEnteros = listaDelRecorridoInOrder(this.arbolBinario, new ListaEnlazadaGenerica<Integer>());
        ListaEnlazadaGenerica<Integer> listaNumerosPares = new ListaEnlazadaGenerica<Integer>();
        listaEnteros.comenzar();
        while (!listaEnteros.fin()) {
            int numero = listaEnteros.proximo();
            if (numero % 2 == 0) {
                listaNumerosPares.agregarFinal(numero);
            }
        }
        return listaNumerosPares;
    }

    private ListaEnlazadaGenerica<Integer> listaDelRecorridoInOrder(ArbolBinario<Integer> arbolBinario, ListaEnlazadaGenerica<Integer> listaEnteros) {//necesita ser invocada con una lista vacia, podria agregar un metodo para resolver esa precondicion e invocar a este mismo metodo.
        if (!arbolBinario.esVacio()) {
            if (arbolBinario.tieneHijoIzquierdo()) {
                listaEnteros = listaDelRecorridoInOrder(arbolBinario.getHijoIzquierdo(), listaEnteros);
            }
            listaEnteros.agregarFinal(arbolBinario.getDato());
            if (arbolBinario.tieneHijoDerecho()) {
                listaEnteros = listaDelRecorridoInOrder(arbolBinario.getHijoDerecho(), listaEnteros);
            }
        }
        return listaEnteros;
    }

    public tp1.ejercicio2.ListaEnlazadaGenerica<Integer> numerosParesPostOrder() {
        ListaEnlazadaGenerica<Integer> listaEnteros = listaDelRecorridoPostOrder(this.arbolBinario, new ListaEnlazadaGenerica<Integer>());
        ListaEnlazadaGenerica<Integer> listaNumerosPares = new ListaEnlazadaGenerica<Integer>();
        listaEnteros.comenzar();
        while (!listaEnteros.fin()) {
            int numero = listaEnteros.proximo();
            if (numero % 2 == 0) {
                listaNumerosPares.agregarFinal(numero);
            }
        }
        return listaNumerosPares;
    }

    private ListaEnlazadaGenerica<Integer> listaDelRecorridoPostOrder(ArbolBinario<Integer> arbolBinario, ListaEnlazadaGenerica<Integer> listaEnteros) {//necesita ser invocada con una lista vacia, podria agregar un metodo para resolver esa precondicion e invocar a este mismo metodo.
        if (!arbolBinario.esVacio()) {
            if (arbolBinario.tieneHijoIzquierdo()) {
                listaEnteros = listaDelRecorridoPostOrder(arbolBinario.getHijoIzquierdo(), listaEnteros);
            }

            if (arbolBinario.tieneHijoDerecho()) {
                listaEnteros = listaDelRecorridoPostOrder(arbolBinario.getHijoDerecho(), listaEnteros);
            }
            listaEnteros.agregarFinal(arbolBinario.getDato());
//            System.out.println("Lista postOr: " + listaEnteros.toString());
        }
        return listaEnteros;
    }
}
