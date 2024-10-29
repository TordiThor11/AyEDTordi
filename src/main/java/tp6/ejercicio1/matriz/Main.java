package tp6.ejercicio1.matriz;

public class Main {
    public static void main(String[] args) {
        GrafoImplMatrizAdy<Integer> grafoImplMatrizAdy = new GrafoImplMatrizAdy<Integer>(5);//Creo un grafo de 5 vertices de integer

        grafoImplMatrizAdy.agregarVertice(new VerticeImplMatrizAdy<>(1));
        grafoImplMatrizAdy.agregarVertice(new VerticeImplMatrizAdy<>(2));
        grafoImplMatrizAdy.agregarVertice(new VerticeImplMatrizAdy<>(3));
        grafoImplMatrizAdy.agregarVertice(new VerticeImplMatrizAdy<>(4));
        grafoImplMatrizAdy.agregarVertice(new VerticeImplMatrizAdy<>(5));
//        System.out.println(grafoImplMatrizAdy.listaDeVertices().toString());
        grafoImplMatrizAdy.conectar(grafoImplMatrizAdy.vertice(1), grafoImplMatrizAdy.vertice(2));
        grafoImplMatrizAdy.conectar(grafoImplMatrizAdy.vertice(1), grafoImplMatrizAdy.vertice(4));
        grafoImplMatrizAdy.conectar(grafoImplMatrizAdy.vertice(1), grafoImplMatrizAdy.vertice(3));
        grafoImplMatrizAdy.conectar(grafoImplMatrizAdy.vertice(2), grafoImplMatrizAdy.vertice(1), 11);
//        grafoImplMatrizAdy.desConectar(grafoImplMatrizAdy.vertice(1), grafoImplMatrizAdy.vertice(2));
        System.out.println(grafoImplMatrizAdy.vertice(3));
    }
}
