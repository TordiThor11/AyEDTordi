package tp6.ejercicio1;

public class Main {
    public static void main(String[] args) {
        GrafoImplMatrizAdy<Integer> grafoImplMatrizAdy = new GrafoImplMatrizAdy<Integer>(5);//Creo un grafo de 5 vertices de integer
        grafoImplMatrizAdy.agregarVertice(new VerticeImplMatrizAdy<>(1));
        grafoImplMatrizAdy.agregarVertice(new VerticeImplMatrizAdy<>(2));
//        System.out.println(grafoImplMatrizAdy.listaDeVertices().toString());
    }
}
