package tp6.ejercicio1.lista;

public class Main {
    public static void main(String[] args) {
        GrafoImplListAdy<Integer> grafoImplListAdy = new GrafoImplListAdy<Integer>();

        grafoImplListAdy.agregarVertice(new VerticeImplListAdy<>(1));
        grafoImplListAdy.agregarVertice(new VerticeImplListAdy<>(2));
        grafoImplListAdy.agregarVertice(new VerticeImplListAdy<>(3));
        grafoImplListAdy.agregarVertice(new VerticeImplListAdy<>(4));
        grafoImplListAdy.agregarVertice(new VerticeImplListAdy<>(5));
//        System.out.println(grafoImplListAdy.listaDeVertices().toString());

        grafoImplListAdy.conectar(grafoImplListAdy.vertice(1), grafoImplListAdy.vertice(2));
        grafoImplListAdy.conectar(grafoImplListAdy.vertice(1), grafoImplListAdy.vertice(4));
        grafoImplListAdy.conectar(grafoImplListAdy.vertice(1), grafoImplListAdy.vertice(3));
        grafoImplListAdy.conectar(grafoImplListAdy.vertice(2), grafoImplListAdy.vertice(1), 11);

//        grafoImplListAdy.desConectar(grafoImplListAdy.vertice(2), grafoImplListAdy.vertice(1));

        System.out.println(grafoImplListAdy.esAdyacente(grafoImplListAdy.vertice(2), grafoImplListAdy.vertice(1)));
        System.out.println(grafoImplListAdy.peso(grafoImplListAdy.vertice(2), grafoImplListAdy.vertice(1)));
    }
}
