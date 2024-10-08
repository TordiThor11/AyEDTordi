package tp5.ejercicio1;

public class Main {
    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.agregar(10);
        minHeap.agregar(11);
        minHeap.agregar(12);
        minHeap.imprimir();
        System.out.println(minHeap.tope().toString());
    }
}
