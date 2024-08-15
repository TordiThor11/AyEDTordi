package tp1.ejercicio3;

import java.util.List;

public class PilaGenerica<T> {
    private ListaGenerica<T> listaGenerica;

    public PilaGenerica(ListaGenerica<T> listaGenerica) {
        this.listaGenerica = listaGenerica;
    }
    public void apilar(T elemento){
        listaGenerica.agregarFinal(elemento);
    }
    public T desapilar(){
        if(listaGenerica.esVacia()){
            return null; //Deberia ser trabajado con exeption o returns optativos (parametros defensivos)
        }
        var elemento = listaGenerica.elemento(listaGenerica.tamanio() - 1);   //pos 0 es el comienzo de la lista
        listaGenerica.eliminarEn(listaGenerica.tamanio() - 1);
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
