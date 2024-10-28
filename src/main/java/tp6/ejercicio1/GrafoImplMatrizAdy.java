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

        v.setPosicion(vertices.tamanio());//La posicion del primer vertice es 0.
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
        matrizAdy[origen.getPosicion()][destino.getPosicion()] = 1;
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        matrizAdy[origen.getPosicion()][destino.getPosicion()] = peso;
    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {
        matrizAdy[origen.getPosicion()][destino.getPosicion()] = 0;
    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) { //si origen apunta a destino, entonces es true.

        return !(matrizAdy[origen.getPosicion()][destino.getPosicion()] == 0);
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        return matrizAdy[origen.getPosicion()][destino.getPosicion()];
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
        ListaGenerica<Arista<T>> listaVertices = new ListaEnlazadaGenerica<Arista<T>>();
        for (int i = 0; i < maxVertices; i++) {
            if (matrizAdy[v.getPosicion()][i] != 0) {
                listaVertices.agregarFinal(new AristaImpl<T>(vertices.elemento(i), matrizAdy[v.getPosicion()][i]));
            }
        }
        return listaVertices;
    }

    @Override
    public Vertice<T> vertice(int posicion) {
        return vertices.elemento(posicion);
    }
}
