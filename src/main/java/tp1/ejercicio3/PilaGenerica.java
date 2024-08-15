package tp1.ejercicio3;

import tp1.ejercicio2.ListaEnlazadaGenerica;

public class PilaGenerica<T> {
    private ListaEnlazadaGenerica<T> datos;

    public PilaGenerica(ListaGenerica<T> listaGenerica) {
        this.datos = new ListaEnlazadaGenerica<T>();
    }
    public void apilar(T elemento){
        datos.agregarFinal(elemento);
    }
    public T desapilar(){
        if(datos.esVacia()){
            return null; //Deberia ser trabajado con exeption o returns optativos (parametros defensivos)
        }
        var elemento = datos.elemento(datos.tamanio() - 1);   //pos 0 es el comienzo de la lista
        datos.eliminarEn(datos.tamanio() - 1);
        return elemento;
    }
    public T tope(){
        if(datos.esVacia()){
            return null; //Deberia ser trabajado con exeption o returns optativos (parametros defensivos)
        }
        return datos.elemento(datos.tamanio() - 1); //Tamanio retorna la cantidad de elementos. Si tiene 3 elementos, el ultimo elemento esta en la pos 2. La lista comienza en 0
    }
    public boolean esVacia(){
        return datos.esVacia();
    }

}
