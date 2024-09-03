package tp2.ejercicio4;

import tp1.ejercicio2.ListaEnlazadaGenerica;
import tp1.ejercicio2.ListaGenerica;

public class TestModulosInternos {
    public static void main(String[] args) throws Exception {
        AnalizadorArbol analizadorArbol = new AnalizadorArbol();
        ListaGenerica<Integer> listaEnteros = new ListaEnlazadaGenerica<>();
        listaEnteros.agregarFinal(4);
        listaEnteros.agregarFinal(10);
        listaEnteros.agregarFinal(1);
        listaEnteros.agregarFinal(9);
        while (!listaEnteros.fin())
            System.out.print(listaEnteros.proximo() + "-");
        System.out.println("El numero mayor es " + analizadorArbol.devolverNumeroMayor(listaEnteros));

    }
}
