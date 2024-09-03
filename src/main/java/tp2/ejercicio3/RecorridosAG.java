package tp2.ejercicio3;

import tp1.ejercicio2.ListaEnlazadaGenerica;
import tp1.ejercicio2.ListaGenerica;
import tp1.ejercicio3.ColaGenerica;

public class RecorridosAG {

    private boolean esImpar(int numero) {
        return numero % 2 == 1;
    }

    private boolean esMayor(int primero, int segundo) { //retorna true si el primero es mayor
        return primero > segundo;
    }


    public ListaGenerica<Integer> recorrerPreOrder(ArbolGeneral<Integer> arbolGeneral) { //--> 10 - 11 - 5 - 15
//        System.out.println("Nuevo arbol...");
        ListaGenerica<Integer> listaFinal = new ListaEnlazadaGenerica<Integer>();
//        System.out.println("Entro al if esVacio: " + !arbolGeneral.esVacio());
        if (!arbolGeneral.esVacio()) {                                       //Si el arbol no es vacio entra al if
            listaFinal.agregarFinal(arbolGeneral.getDato());                //Agrego el dato del arbol a la lista final
            System.out.println(arbolGeneral.getDato());
            if (arbolGeneral.tieneHijos()) {
//                System.out.println("Entro tiene hijos: " + arbolGeneral.tieneHijos());
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

    public ListaGenerica<Integer> recorrerPostOrder(ArbolGeneral<Integer> arbolGeneral) { //salida --> 5-11-15-10
        System.out.println("Entro al arbol con dato (Sin guardarlo, solo entro): " + arbolGeneral.getDato());
        ListaGenerica<Integer> listaFinal = new ListaEnlazadaGenerica<Integer>();
        if (!arbolGeneral.esVacio()) {                                       //Si el arbol no es vacio entra al if
            if (!arbolGeneral.tieneHijos()) {//Si el arbol no tiene hijos, entra al if
            } else {
                ListaGenerica<ArbolGeneral<Integer>> listaHijos = arbolGeneral.getHijos();//Guardo los hijos del arbol en otra estructura auxiliar
                listaHijos.comenzar();                                                     //Preparo la lista
                while (!listaHijos.fin()) { //Miestras la lista de hijos no llegue a su fin. fin() da true si llegamos al ultimo elemento de la lista
                    ArbolGeneral<Integer> hijoActual = listaHijos.proximo();    //Retorna el elemento actual y avanza al siguiente.
                    ListaGenerica<Integer> listaNumerosResultanteDeLaRecursion = this.recorrerInOrder(hijoActual);
//                    listaFinal = this.recorrerInOrder(hijoActual);
                    while (!listaNumerosResultanteDeLaRecursion.fin()) {  //Mientras no llegue al final
                        listaFinal.agregarFinal(listaNumerosResultanteDeLaRecursion.proximo());
                    }
                }
            }
            listaFinal.agregarFinal(arbolGeneral.getDato()); //proceso dato, Agrego el dato del arbol a la lista final
            System.out.println("Se agrego el dato: " + arbolGeneral.getDato());
        }
        return listaFinal;
    }

    public ListaGenerica<Integer> recorrerInOrder(ArbolGeneral<Integer> arbolGeneral) {
        System.out.println("Entro al arbol con dato (Sin guardarlo, solo entro): " + arbolGeneral.getDato());
        ListaGenerica<Integer> listaFinal = new ListaEnlazadaGenerica<Integer>();
        if (!arbolGeneral.esVacio()) {
            if (arbolGeneral.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Integer>> listaHijos = arbolGeneral.getHijos();//Guardo los hijos del arbol en otra estructura auxiliar
                listaHijos.comenzar();                                                     //Preparo la lista

                ArbolGeneral<Integer> hijoActual = listaHijos.proximo();    //Retorna el elemento actual y avanza al siguiente.

                ListaGenerica<Integer> listaNumerosResultanteDeLaRecursion = this.recorrerInOrder(hijoActual);
                while (!listaNumerosResultanteDeLaRecursion.fin()) {  //Mientras no llegue al final
                    listaFinal.agregarFinal(listaNumerosResultanteDeLaRecursion.proximo());
                }
                listaFinal.agregarFinal(arbolGeneral.getDato()); //proceso dato, Agrego el dato del arbol a la lista final
                System.out.println("Se agrego el dato ya que se proceso el primer hijo (izq): " + arbolGeneral.getDato());

                while (!listaHijos.fin()) { //Miestras la lista de hijos no llegue a su fin. fin() da true si llegamos al ultimo elemento de la lista
                    hijoActual = listaHijos.proximo();    //Retorna el elemento actual y avanza al siguiente.
                    listaNumerosResultanteDeLaRecursion = this.recorrerInOrder(hijoActual);
                    while (!listaNumerosResultanteDeLaRecursion.fin()) {  //Mientras no llegue al final
                        listaFinal.agregarFinal(listaNumerosResultanteDeLaRecursion.proximo());
                    }
                }
            } else {
                listaFinal.agregarFinal(arbolGeneral.getDato()); //proceso dato, Agrego el dato del arbol a la lista final
                System.out.println("Se agrego el dato ya que no tenia hijos el arbol: " + arbolGeneral.getDato());
            }

        }
        return listaFinal;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {//podria llamarse diferente, ya que sirve para filtrar
        //Método que retorna una lista con los elementos impares del árbol “a” que sean mayores
        //al valor “n” pasados como parámetros, recorrido en preorden.
        ListaGenerica<Integer> listaRecorrida = recorrerPreOrder(a);
        ListaGenerica<Integer> listaFiltrada = new ListaEnlazadaGenerica<Integer>();
        while (!listaRecorrida.fin()) {
            Integer numero = listaRecorrida.proximo();
            if (esImpar(numero) && esMayor(numero, n)) {
//                System.out.println("Numero agregado a la lista filtrada: " + numero);
                listaFiltrada.agregarFinal(numero);
            }
        }
        return listaFiltrada;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
        //Método que retorna una lista con los elementos impares del árbol “a” que sean mayores
        //    al valor “n” pasados como parámetros, recorrido en inorden.
        return null;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
        //Método que retorna una lista con los elementos impares del árbol “a” que sean mayores
        //    al valor “n” pasados como parámetros recorrido en postorden.
        ListaGenerica<Integer> listaRecorrida = recorrerPostOrder(a);
        ListaGenerica<Integer> listaFiltrada = new ListaEnlazadaGenerica<Integer>();
        while (!listaRecorrida.fin()) {
            Integer numero = listaRecorrida.proximo();
            if (esImpar(numero) && esMayor(numero, n)) {
//                System.out.println("Numero agregado a la lista filtrada: " + numero);
                listaFiltrada.agregarFinal(numero);
            }
        }
        return listaFiltrada;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
        //Método que retorna una lista con los elementos impares del árbol “a” que sean mayores
        //al valor “n” pasados como parámetros, recorrido por niveles.
        return null;
    }

    public ListaGenerica<Integer> recorridoPorNiveles(ArbolGeneral<Integer> arbolGeneral) {//Recorrido 10-11-15-5
        ListaGenerica<Integer> listaFinal = new ListaEnlazadaGenerica<Integer>();
        ColaGenerica<ArbolGeneral<Integer>> colaGenerica = new ColaGenerica<ArbolGeneral<Integer>>();
        colaGenerica.encolar(arbolGeneral);
        while (!colaGenerica.esVacia()) {
            ArbolGeneral<Integer> nodo = colaGenerica.desencolar();
            listaFinal.agregarFinal(nodo.getDato());
            System.out.println("Se agrego a la lista el dato: " + nodo.getDato());
            ListaGenerica<ArbolGeneral<Integer>> listaHijos = nodo.getHijos();
            while (!listaHijos.fin()) {//Si me falta el ultimo dato puede ser esto
                colaGenerica.encolar(listaHijos.proximo());//Agarra el nodo y avanza al siguiente
            }
        }
        return listaFinal;
    }

}
