package tp2.ejercicio4;

import tp1.ejercicio2.ListaEnlazadaGenerica;
import tp1.ejercicio2.ListaGenerica;
import tp1.ejercicio3.ColaGenerica;
import tp2.ejercicio3.ArbolGeneral;

public class AnalizadorArbol {
    public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) throws Exception {
        //listaPromedios va sumando los valores de cada nodo en su posicion correspondiente. Ejemplo: La raiz se suma en la pos=0, el nivel 1 se suma en la pos=1, etc.
        ListaGenerica<Integer> listaPromedios = new ListaEnlazadaGenerica<Integer>();
        //listaCantidadNodosPorNivel va guardando la cantidad de nodos que tiene cada nivel para despues hacer un calculo con listaPromedios.
        ListaGenerica<Integer> listaCantidadNodosPorNivel = new ListaEnlazadaGenerica<Integer>();
        //nivelCola es la cola usada para conocer el nivel de cada nodo.
        ColaGenerica<Integer> nivelCola = new ColaGenerica<Integer>();
        //colaNodosDelArbol es usada para recorrer el arbol por niveles.
        ColaGenerica<ArbolGeneral<AreaEmpresa>> colaNodosDelArbol = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
        //Encolo la raiz y el nivel 0 (nivel de la raiz).
        colaNodosDelArbol.encolar(arbol);
        nivelCola.encolar(0);

        while (!colaNodosDelArbol.esVacia()) {
            ArbolGeneral<AreaEmpresa> nodo = colaNodosDelArbol.desencolar();
            int nivel = nivelCola.desencolar();
            if (listaPromedios.tamanio() == nivel) {  //if (mi lista entra en un nuevo nivel).
                listaPromedios.agregarFinal(nodo.getDato().getTardanzaDeTransmision());
                listaCantidadNodosPorNivel.agregarFinal(1);//Cantidad de nodos en el nuevo nivel es 1
            } else {
                int sumaValores = nodo.getDato().getTardanzaDeTransmision() + listaPromedios.elemento(nivel + 1);//Suma el valor del nodo con los valores ya sumados anteriormente en dicho nivel.
                listaPromedios.reemplazarEn(sumaValores, nivel + 1);
                listaCantidadNodosPorNivel.reemplazarEn(listaCantidadNodosPorNivel.elemento(nivel + 1) + 1, nivel + 1);//Le sumo a la cantidad de nodos de un nivel
            }

//            System.out.println("Se agrego a la lista el dato: " + nodo.getDato() + "//El nivel es " + nivel);
            ListaGenerica<ArbolGeneral<AreaEmpresa>> listaHijos = nodo.getHijos();
            listaHijos.comenzar();
            while (!listaHijos.fin()) {
                colaNodosDelArbol.encolar(listaHijos.proximo());//Agarra el nodo y avanza al siguiente
                nivelCola.encolar(nivel + 1);
            }


        }
        //Calculo porcentajes
        ListaGenerica<Integer> listaNumeros = new ListaEnlazadaGenerica<Integer>();
        listaPromedios.comenzar();
        listaCantidadNodosPorNivel.comenzar();
        while (!listaPromedios.fin()) {
            listaNumeros.agregarFinal(listaPromedios.proximo() / listaCantidadNodosPorNivel.proximo());
        }
        return devolverNumeroMayor(listaNumeros);
    }

    public ListaGenerica<Integer> tranformarAListaNumerica(ListaGenerica<AreaEmpresa> listaAreaEmpresa) throws Exception {
        ListaGenerica<Integer> listaNumerica = new ListaEnlazadaGenerica<Integer>();
        listaAreaEmpresa.comenzar();
        if (listaAreaEmpresa.esVacia()) {
            throw new Exception("La lista no puede estar vacia"); //Resuelvo con exeption para no usar null o -1.
        }
        while (!listaAreaEmpresa.fin()) {
            AreaEmpresa nodoAreaEmpresa = listaAreaEmpresa.proximo();
            listaNumerica.agregarFinal(nodoAreaEmpresa.getTardanzaDeTransmision());
        }
        return listaNumerica;
    }

    public ListaGenerica<AreaEmpresa> recorridoPorNiveles(ArbolGeneral<AreaEmpresa> arbolGeneral) {
        ListaGenerica<AreaEmpresa> listaFinal = new ListaEnlazadaGenerica<AreaEmpresa>();
        ColaGenerica<Integer> nivelCola = new ColaGenerica<Integer>();
        ColaGenerica<ArbolGeneral<AreaEmpresa>> colaGenerica = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
        //Encolo la raiz
        colaGenerica.encolar(arbolGeneral);
        nivelCola.encolar(0);

        while (!colaGenerica.esVacia()) {
            ArbolGeneral<AreaEmpresa> nodo = colaGenerica.desencolar();
            int nivel = nivelCola.desencolar();
            listaFinal.agregarFinal(nodo.getDato());
//            System.out.println("Se agrego a la lista el dato: " + nodo.getDato() + "//El nivel es " + nivel);
            ListaGenerica<ArbolGeneral<AreaEmpresa>> listaHijos = nodo.getHijos();
            while (!listaHijos.fin()) {
                colaGenerica.encolar(listaHijos.proximo());//Agarra el nodo y avanza al siguiente
                nivelCola.encolar(nivel + 1);
            }

        }
        return listaFinal;
    }

    public int devolverNumeroMayor(ListaGenerica<Integer> listaNumeros) throws Exception {
        listaNumeros.comenzar();
        if (listaNumeros.esVacia()) {
            throw new Exception("La lista no puede estar vacia"); //Resuelvo con exeption para no usar null o -1.
        }
        int numeroMayor = listaNumeros.proximo();
        while (!listaNumeros.fin()) {
            int numeroComparar = listaNumeros.proximo();
            if (numeroComparar > numeroMayor) {
                numeroMayor = numeroComparar;
            }
        }
        return numeroMayor;
    }
}

