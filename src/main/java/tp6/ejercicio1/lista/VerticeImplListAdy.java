package tp6.ejercicio1.lista;

import tp1.ejercicio2.ListaEnlazadaGenerica;
import tp1.ejercicio2.ListaGenerica;
import tp6.ejercicio1.AristaImpl;
import tp6.interfaces.Arista;
import tp6.interfaces.Vertice;

public class VerticeImplListAdy<T> implements Vertice<T> {

    private ListaGenerica<Arista<T>> adyacentes;
    private T dato;
    private int posicion;


    public VerticeImplListAdy(T dato) {
        adyacentes = new ListaEnlazadaGenerica<>();
        this.dato = dato;
    }

    public VerticeImplListAdy(T dato, int posicion) {
        this(dato);
        this.posicion = posicion;
    }

    public void desconectar(Vertice<T> vertice) {
        adyacentes.eliminar(obtenerArista(vertice));
    }

    public boolean esAdyacente(Vertice<T> vertice) {
        var arista = obtenerArista(vertice);
        return this.adyacentes.incluye(arista);
    }

    public int peso(Vertice<T> vertice) {
        var arista = obtenerArista(vertice);
        if (arista == null) {
            return 0; //si no encuentra la arista, entonces no tiene conexion con el vertice, por lo que es 0.
        }
        return arista.peso();
    }

    public Arista<T> obtenerArista(Vertice<T> vertice) {
        adyacentes.comenzar();
        Arista<T> arista;
        while (!adyacentes.fin()) {
            arista = adyacentes.proximo();
            if (arista.verticeDestino() == vertice) {
                return arista;
            }
        }
        return null;
    }

    public void conectar(Vertice<T> vertice) {
        adyacentes.agregarFinal(new AristaImpl<>(vertice, 1));
    }

    public void conectar(Vertice<T> vertice, int peso) {
        adyacentes.agregarFinal(new AristaImpl<>(vertice, peso));
    }

    public ListaGenerica<Arista<T>> obtenerAdyacentes() {
        return this.adyacentes;
    }

    @Override
    public T dato() {
        return dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public int getPosicion() {
        return posicion;
    }

    @Override
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
