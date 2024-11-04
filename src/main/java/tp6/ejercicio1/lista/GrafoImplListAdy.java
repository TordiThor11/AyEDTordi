package tp6.ejercicio1.lista;

import tp1.ejercicio2.ListaEnlazadaGenerica;
import tp1.ejercicio2.ListaGenerica;
import tp6.interfaces.Arista;
import tp6.interfaces.Grafo;
import tp6.interfaces.Vertice;

public class GrafoImplListAdy<T> implements Grafo<T> {
    private ListaGenerica<Vertice<T>> vertices;

    public GrafoImplListAdy() {
        this.vertices = new ListaEnlazadaGenerica<>();
    }

    @Override
    public void agregarVertice(Vertice<T> v) {
        v.setPosicion(vertices.tamanio());
        vertices.agregarFinal(v);
    }

    @Override
    public void eliminarVertice(Vertice<T> v) {
        vertices.eliminar(v);
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        VerticeImplListAdy<T> origenImpl = (VerticeImplListAdy<T>) origen;
        VerticeImplListAdy<T> destinoImpl = (VerticeImplListAdy<T>) destino;
        origenImpl.conectar(destinoImpl);
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        VerticeImplListAdy<T> origenImpl = (VerticeImplListAdy<T>) origen;
        VerticeImplListAdy<T> destinoImpl = (VerticeImplListAdy<T>) destino;
        origenImpl.conectar(destinoImpl, peso);
    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {
        VerticeImplListAdy<T> origenImpl = (VerticeImplListAdy<T>) origen;
        VerticeImplListAdy<T> destinoImpl = (VerticeImplListAdy<T>) destino;
        origenImpl.desconectar(destinoImpl);
    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        VerticeImplListAdy<T> origenImpl = (VerticeImplListAdy<T>) origen;
        VerticeImplListAdy<T> destinoImpl = (VerticeImplListAdy<T>) destino;
        return origenImpl.esAdyacente(destinoImpl);
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        VerticeImplListAdy<T> origenImpl = (VerticeImplListAdy<T>) origen;
        VerticeImplListAdy<T> destinoImpl = (VerticeImplListAdy<T>) destino;
        return origenImpl.peso(destinoImpl);
    }

    @Override
    public boolean esVacio() {
        return vertices.esVacia();
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return this.vertices;
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        VerticeImplListAdy<T> verticeImpl = (VerticeImplListAdy<T>) v;
        return ((VerticeImplListAdy<T>) v).obtenerAdyacentes();
    }

    @Override
    public Vertice<T> vertice(int posicion) {
        return this.vertices.elemento(posicion);
    }
}
