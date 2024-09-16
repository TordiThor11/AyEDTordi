package tp3.ejercicio4;

import tp3.libs.ArbolBinario;

public class RedBinariaLlena {
    private ArbolBinario<Integer> arbolBinario;

    public RedBinariaLlena(ArbolBinario<Integer> arbolBinario) {  //Necesito usar un recorrido recursivo para contar, en este caso pre-order.
        this.arbolBinario = arbolBinario;
    }

    public int retardoReenvio() {
        return retardoReenvio(this.arbolBinario, 0);
    }

    private int retardoReenvio(ArbolBinario<Integer> arbolBinario, int segundosCalculados) {
        int contador = segundosCalculados;
        int contadorPorIzq = 0;
        int contadorPorDer = 0;
        if (!arbolBinario.esVacio()) {
            contador += arbolBinario.getDato();
            if (arbolBinario.tieneHijoIzquierdo()) {
                contadorPorIzq = retardoReenvio(arbolBinario.getHijoIzquierdo(), contador);
            }
            if (arbolBinario.tieneHijoDerecho()) {
                contadorPorDer = retardoReenvio(arbolBinario.getHijoDerecho(), contador);
            }
            if (contadorPorIzq > contadorPorDer) {
                contador = +contadorPorIzq;
            }
            if (contadorPorDer > contadorPorIzq) {
                contador = +contadorPorDer;
            }
        }
        return contador;
    }
}
