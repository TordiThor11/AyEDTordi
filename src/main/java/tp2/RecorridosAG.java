package tp2;

import tp1.ejercicio2.ListaEnlazadaGenerica;
import tp1.ejercicio2.ListaGenerica;

public class RecorridosAG {

    private boolean esImpar(int numero) {
        return numero % 2 == 1;
    }

    private boolean esMayor(int primero, int segundo) { //retorna true si el primero es mayor
        return primero > segundo;
    }

    public ListaGenerica<Integer> recorrerPreOrder(ArbolGeneral<Integer> arbolGeneral) {
        ListaGenerica<Integer> listaAux = new ListaEnlazadaGenerica<Integer>();
        System.out.println("Entro: " + !arbolGeneral.esVacio());
        if (!arbolGeneral.esVacio()) {
            listaAux.agregarFinal(arbolGeneral.getDato());
            System.out.println(arbolGeneral.getDato());
            if (arbolGeneral.tieneHijos()) {
                listaAux = this.recorrerPreOrder(arbolGeneral.getHijos().proximo());//Aca esta mal?
            }
        }
        return listaAux;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {
        //Método que retorna una lista con los elementos impares del árbol “a” que sean mayores
        //al valor “n” pasados como parámetros, recorrido en preorden.
        ListaGenerica<Integer> listaAux = new ListaEnlazadaGenerica<Integer>();

        return null;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
        //Método que retorna una lista con los elementos impares del árbol “a” que sean mayores
        //    al valor “n” pasados como parámetros, recorrido en inorden.
        return null;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
        //Método que retorna una lista con los elementos impares del árbol “a” que sean mayores
        //    al valor “n” pasados como parámetros recorrido en postorden.
        return null;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
        //Método que retorna una lista con los elementos impares del árbol “a” que sean mayores
        //al valor “n” pasados como parámetros, recorrido por niveles.
        return null;
    }


}
