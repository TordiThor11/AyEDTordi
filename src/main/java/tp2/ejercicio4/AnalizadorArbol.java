package tp2.ejercicio4;

import tp1.ejercicio2.ListaEnlazadaGenerica;
import tp1.ejercicio2.ListaGenerica;
import tp1.ejercicio3.ColaGenerica;
import tp2.ejercicio3.ArbolGeneral;

public class AnalizadorArbol {
    public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {


        return 0;
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
            System.out.println("Se agrego a la lista el dato: " + nodo.getDato() + "//El nivel es " + nivel);
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
            throw new Exception("La lista no puede estar vacia"); //Resuelvo con exeption para no usar null/-1.
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

