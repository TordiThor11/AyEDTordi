package tp6.ejercicio1;

import tp1.ejercicio2.ListaEnlazadaGenerica;
import tp1.ejercicio2.ListaGenerica;
import tp6.interfaces.Arista;
import tp6.interfaces.Grafo;
import tp6.interfaces.Vertice;

public class GrafoImplMatrizAdy<T> implements Grafo<T> {
    private ListaGenerica<Vertice<T>> vertices;

    private int maxVertices; //Deberia de estar como variable de instancia o como constante?
    private int[][] matrizAdy;

    public GrafoImplMatrizAdy(int maxVertices) {
        this.maxVertices = maxVertices;
        this.vertices = new ListaEnlazadaGenerica<Vertice<T>>();
        this.matrizAdy = new int[maxVertices][maxVertices];
    }

    @Override
    public void agregarVertice(Vertice<T> v) {
        if (vertices.incluye(v) || vertices.tamanio() == maxVertices) {//Si el vertice ya esta en la lista o ya tiene el tamanio maximo, termina la funcion
            return;
        }

        vertices.agregarFinal(v);
    }

    @Override
    public void eliminarVertice(Vertice<T> v) {
        if (vertices.eliminar(v)) {  //Si se puede eliminar el elemento, entonces...
            //falta eliminar conexiones
        }
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {

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
        return vertices.esVacia();
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return this.vertices;
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
