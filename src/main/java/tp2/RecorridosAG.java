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
        ListaGenerica<Integer> listaFinal = new ListaEnlazadaGenerica<Integer>();
        System.out.println("Entro es vacio: " + !arbolGeneral.esVacio());
        if (!arbolGeneral.esVacio()) {                                       //Si el arbol no es vacio entra al if
            listaFinal.agregarFinal(arbolGeneral.getDato());                //Agrego el dato del arbol a la lista final
            System.out.println(arbolGeneral.getDato());
            if (arbolGeneral.tieneHijos()) {
                System.out.println("Entro tiene hijos: " + arbolGeneral.tieneHijos());
                ListaGenerica<ArbolGeneral<Integer>> listaHijos = arbolGeneral.getHijos();//Guardo los hijos del arbol en otra estructura auxiliar
                listaHijos.comenzar();                                                //Preparo la lista
                while (!listaHijos.fin()) { //Miestras la lista de hijos no llegue a su fin. fin() da true si llegamos al ultimo elemento de la lista
                    ArbolGeneral<Integer> hijoActual = listaHijos.proximo();    //Retorna el elemento actual y avanza al siguiente.
                    ListaGenerica<Integer> listaHijosAux = this.recorrerPreOrder(hijoActual);
                    while (!listaHijosAux.fin()) {  //Mientras no llegue al final
                        listaFinal.agregarFinal(listaHijosAux.proximo());
                    }
                }


            }
        }
        return listaFinal;
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
