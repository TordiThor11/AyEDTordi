package tp5.ejercicio1;

public class Main {
    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();

        minHeap.agregar(12);
        minHeap.agregar(8);
        minHeap.agregar(10);
        minHeap.agregar(9);
        minHeap.agregar(11);
        minHeap.agregar(7);
        minHeap.agregar(5);
        minHeap.agregar(15);
        minHeap.agregar(13);
        minHeap.imprimir();
//        System.out.println(minHeap.tope().toString());
        minHeap.eliminar();
        minHeap.imprimir();
        minHeap.eliminar();
        minHeap.imprimir();
        minHeap.eliminar();
        minHeap.imprimir();
        minHeap.eliminar();
        minHeap.imprimir();
    }
}
