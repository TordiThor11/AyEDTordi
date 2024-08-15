package tp1.ejercicio3;

import tp1.ejercicio2.ListaEnlazadaGenerica;

import java.util.List;

public class ColaGenerica<T>{
    private ListaEnlazadaGenerica<T> datos;

    public ColaGenerica() {
        this.datos = new ListaEnlazadaGenerica<T>();
    }

    public void encolar(T elem){
        listaGenerica.agregarFinal(elem);
    }
    public T desencolar(){
        if(listaGenerica.esVacia()){
            return null; //Deberia ser trabajado con exeption o returns optativos (parametros defensivos)
        }
        var elemento = listaGenerica.elemento(0);   //pos 0 es el comienzo de la lista
        listaGenerica.eliminarEn(0);
        return elemento;
    }

    public T tope(){
        if(listaGenerica.esVacia()){
            return null; //Deberia ser trabajado con exeption o returns optativos (parametros defensivos)
        }
        return listaGenerica.elemento(listaGenerica.tamanio() - 1); //Tamanio retorna la cantidad de elementos. Si tiene 3 elementos, el ultimo elemento esta en la pos 2. La lista comienza en 0
    }
    public boolean esVacia(){
        return listaGenerica.esVacia();
    }

}
