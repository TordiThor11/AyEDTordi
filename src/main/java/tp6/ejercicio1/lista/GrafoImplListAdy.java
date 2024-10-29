package tp6.ejercicio1.lista;

import tp1.ejercicio2.ListaGenerica;
import tp6.interfaces.Arista;
import tp6.interfaces.Grafo;
import tp6.interfaces.Vertice;

public class GrafoImplListAdy<T> implements Grafo<T> {
    private ListaGenerica<VerticeImplListAdy<T>> vertices;

    @Override
    public void agregarVertice(Vertice<T> v) {
        vertices.agregarFinal(v);
    }

    @Override
    public void eliminarVertice(Vertice<T> v) {
        vertices.eliminar(v);
    }

    @Override
    public void conectar(VerticeImplListAdy<T> origen, VerticeImplListAdy<T> destino) {
        origen.
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {

    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {

    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        return false;
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        return 0;
    }

    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return null;
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        return null;
    }

    @Override
    public Vertice<T> vertice(int posicion) {
        return null;
    }
}
