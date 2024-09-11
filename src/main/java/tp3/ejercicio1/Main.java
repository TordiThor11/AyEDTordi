package tp3.ejercicio1;

import tp3.libs.ArbolBinario;

public class Main {
    public static void main(String[] args) throws Exception {
        ArbolBinario<Integer> arbolBinarioMain = setUpArbol();
        System.out.println("Cantidad de hijos: " + arbolBinarioMain.contarHojas());
        ArbolBinario<Integer> arbolEspejo = arbolBinarioMain.espejo();
        System.out.println("Cantidad de hijos: " + arbolEspejo.contarHojas());
    }

    private static ArbolBinario<Integer> setUpArbol() {
        ArbolBinario<Integer> arbolBinarioMain = new ArbolBinario<Integer>(1);              //1
        arbolBinarioMain.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));         //2<---   ---->7
        ArbolBinario<Integer> arbolBinario4 = new ArbolBinario<Integer>(7);                 //3<--   -->5
        ArbolBinario<Integer> arbolBinario2 = new ArbolBinario<Integer>(3);             //4<- ->N    6<- ->N
        ArbolBinario<Integer> arbolBinario3 = new ArbolBinario<Integer>(5);
        arbolBinario3.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
        arbolBinario4.agregarHijoDerecho(arbolBinario3);
        arbolBinario2.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
        arbolBinario4.agregarHijoIzquierdo(arbolBinario2);
        arbolBinarioMain.agregarHijoDerecho(arbolBinario4);
        return arbolBinarioMain;
    }
}
