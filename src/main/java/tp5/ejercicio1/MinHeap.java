package tp5.ejercicio1;

import tp1.ejercicio3.ListaGenerica;

public class MinHeap<T extends Comparable<T>> implements ColaPrioridades<T> {

    public static final int tamanioFisicoDeHeap = 100;

    private int cantDatos;
    //El indice 0 lo puedo ignorar para facilitar las operaciones matematicas (multiplicacion o division)
    private T[] datos = (T[]) new Comparable[tamanioFisicoDeHeap];

    public MinHeap() {
        this.cantDatos = 0;
    }

    public MinHeap(ListaGenerica<T> listaGenerica) {
        this.cantDatos = 0;
        listaGenerica.comenzar();
        while (!listaGenerica.esVacia()) {
            agregar(listaGenerica.proximo());
        }
    }

    @Override
    public T tope() {
        return this.datos[1]; //el tope esta en la posicion 1 del vector. La pos 0 no se usa por comodidad de implementacion.
    }

    @Override
    public boolean esVacia() {
        return cantDatos == 0;
    }

    @Override
    public boolean eliminar() {
        datos[1] = datos[cantDatos];
        datos[cantDatos] = null;
        cantDatos--;
        percolateDown();
        return true;
    }

    private void percolateDown() {
        if (cantDatos == 0) {
            return;
        }
        int pos = 1;
        while (pos * 2 <= cantDatos) {
            if (datos[(pos * 2) + 1].compareTo(datos[pos * 2]) < 0) {
                T temp = datos[(pos * 2) + 1];
                datos[(pos * 2) + 1] = datos[pos * 2];
                datos[pos * 2] = temp;
            }

            if (datos[pos * 2].compareTo(datos[pos]) < 0) {
                T temp = datos[pos];
                datos[pos] = datos[pos * 2];
                datos[pos * 2] = temp;
            }
            pos = pos * 2;
        }
    }

    @Override
    public boolean agregar(T dato) {
        this.datos[cantDatos + 1] = dato; //esto puede romper la propiedad del heap, se tiene que reacomodoar.
        cantDatos++;
        percolateUp();
        return true;
    }

    private void percolateUp() {    //restaura el orden de la heap al agregar un elemento
        if (cantDatos == 1)
            return; //no tiene sentido el percolate con un solo numero. Con quien compara?
        /*• El filtrado termina cuando la clave k alcanza la raíz o un nodo cuyo padre tiene
        una clave menor.

        El filtrado hacia arriba restaura la propiedad de orden intercambiando k a lo
        largo del camino hacia arriba desde el lugar de inserción.
         */
        int i = this.cantDatos;
        Comparable<T> temp = (Comparable<T>) this.datos[i];
        while ((i / 2 > 0) && (this.datos[i / 2] != null) && (temp.compareTo(this.datos[i / 2]) <= 0)) { //i / 2 > 0 --> esta condicion se encarga de no entrar en una posicion erronea.
            this.datos[i] = this.datos[i / 2];
            i = i / 2;
        }
        this.datos[i] = (T) temp;
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
