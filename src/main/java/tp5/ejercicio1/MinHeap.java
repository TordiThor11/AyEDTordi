package tp5.ejercicio1;

import tp1.ejercicio3.ListaGenerica;

public class MinHeap<T> implements ColaPrioridades<T> {

    public static final int tamanioFisicoDeHeap = 100;

    private int cantDatos;
    //El indice 0 lo puedo ignorar para facilitar las operaciones matematicas (multiplicacion o division)
    private T[] datos = (T[]) new Comparable[tamanioFisicoDeHeap];

    public MinHeap() {
        this.cantDatos = 0;
    }

    public MinHeap(ListaGenerica<T> listaGenerica) {
        //los elementos de la lista de colocan en la heap segun el orden
    }

    @Override
    public boolean esVacia() {
        return cantDatos == 0;
    }

    @Override
    public boolean eliminar() {
        return false;
    }

    @Override
    public boolean agregar(T dato) {
        boolean todoOk = false;//borrar?
        this.datos[cantDatos + 1] = dato; //esto puede romper la propiedad del heap, se tiene que reacomodoar.
        cantDatos++;

        return true;
    }

    private void percolateUp() {    //restaura el orden de la heap al agregar un elemento
        /*• El filtrado termina cuando la clave k alcanza la raíz o un nodo cuyo padre tiene
        una clave menor.

        El filtrado hacia arriba restaura la propiedad de orden intercambiando k a lo
        largo del camino hacia arriba desde el lugar de inserción.
         */
        int i = this.cantDatos;
        while (i / 2 > 0 & ) { //i / 2 > 0 --> esta condicion se encarga de no entrar en una posicion erronea.

        }
    }

    @Override
    public T tope() {
        return this.datos[1]; //el tope esta en la posicion 1 del vector. La pos 0 no se usa por comodidad de implementacion.
    }

    public void imprimir() {
        int i = 0;
        int cantidadDatosRestantes = this.cantDatos;
        while (i < tamanioFisicoDeHeap && cantidadDatosRestantes > 0) {
            if (datos[i] != null) {
                System.out.print(datos[i].toString() + "->");
                cantidadDatosRestantes--;
            }
            i++;
        }
        System.out.println("end");
    }
}
