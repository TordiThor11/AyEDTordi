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
        ColaGenerica<ArbolGeneral<AreaEmpresa>> colaGenerica = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
        colaGenerica.encolar(arbolGeneral);
        while (!colaGenerica.esVacia()) {
            ArbolGeneral<AreaEmpresa> nodo = colaGenerica.desencolar();
            listaFinal.agregarFinal(nodo.getDato());
//            System.out.println("Se agrego a la lista el dato: " + nodo.getDato());
            ListaGenerica<ArbolGeneral<AreaEmpresa>> listaHijos = nodo.getHijos();
            while (!listaHijos.fin()) {//Si me falta el ultimo dato puede ser esto
                colaGenerica.encolar(listaHijos.proximo());//Agarra el nodo y avanza al siguiente
            }
        }
        return listaFinal;
    }
}

