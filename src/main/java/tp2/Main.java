package tp2;

import tp1.ejercicio2.ListaGenerica;

public class Main {
    public static void main(String[] args) {
        var recorredor = new RecorridosAG();
        ArbolGeneral<Integer> arbolGeneral = new ArbolGeneral<Integer>(10);

        ArbolGeneral<Integer> arbolGeneral2 = new ArbolGeneral<Integer>(11);
        arbolGeneral2.agregarHijo(new ArbolGeneral<Integer>(5));

        arbolGeneral.agregarHijo(arbolGeneral2);
        arbolGeneral.agregarHijo(new ArbolGeneral<>(15));

        //Test pre-order --> 10 - 11 - 5 - 15
        //var listaPreOrder = recorredor.recorrerPreOrder(arbolGeneral);
        //System.out.println("Tamanio de lista: " + listaPreOrder.tamanio()); //Lista recorrida preorder sin filtrar ningun dato
        //var listaFiltrada = recorredor.numerosImparesMayoresQuePreOrden(arbolGeneral, 13);
        //System.out.println("Tamanio de lista: " + listaFiltrada.tamanio());

        //Test post-order --> 11 - 5 - 15 - 10
        /*var listaPostOrder = recorredor.recorrerPostOrder(arbolGeneral);
        System.out.println("Tamanio de lista: " + listaPostOrder.tamanio());
        var listaFiltradaPostOrder = recorredor.numerosImparesMayoresQuePostOrden(arbolGeneral, 13);
        System.out.println("Tamanio de la lista postorder filtrada: " + listaFiltradaPostOrder.tamanio());
        listaPostOrder.comenzar();
        while (!listaPostOrder.fin()) {
            System.out.println(listaPostOrder.proximo());
        }*/

        //Probando me di cuenta que


        //Test in-order --> 5 - 11 - 10 - 15
        ListaGenerica<Integer> listaInOrder = recorredor.recorrerInOrder(arbolGeneral);
        System.out.println("Tamanio de la lista in-order: " + listaInOrder.tamanio());
        listaInOrder.comenzar();
        while (!listaInOrder.fin()) {
            System.out.println(listaInOrder.proximo());
        }
    }
}
