package tp3.ejercicio5;

import tp1.ejercicio3.ColaGenerica;
import tp3.libs.ArbolBinario;

public class ProfundidadDeArbolBinario {
    private ArbolBinario<Integer> arbolBinario;

    public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

    public int sumaElementosProfundidad(int p) { //Suma todos los elementos que se encuentran en el nivel p
        if (p == 0) {
            return this.arbolBinario.getDato(); //Retorno el dato de la raiz si p==0
        }
        int sumatoria = 0;
        ColaGenerica<ArbolBinario<Integer>> colaNodos = new ColaGenerica<>();
        ColaGenerica<Integer> colaNiveles = new ColaGenerica<>();
        colaNodos.encolar(this.arbolBinario);
        colaNiveles.encolar(0);//Nivel 0, la raiz del arbol
        while (!colaNodos.esVacia()) {
            ArbolBinario<Integer> nodoActual = colaNodos.desencolar();
            int nivelActual = colaNiveles.desencolar();
            if (nivelActual == p) {
                sumatoria += nodoActual.getDato();
            }
            if (nodoActual.tieneHijoIzquierdo()) {
                colaNodos.encolar(nodoActual.getHijoIzquierdo());
                colaNiveles.encolar(nivelActual + 1);
            }
            if (nodoActual.tieneHijoDerecho()) {
                colaNodos.encolar(nodoActual.getHijoDerecho());
                colaNiveles.encolar(nivelActual + 1);
            }
        }
        return sumatoria;
    }
}
