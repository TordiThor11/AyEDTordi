package tp1.ejercicio1;

public class TestListaDeEnterosConArreglos {
	static void imprimirListaRecursivo(ListaDeEnteros lista) {
		if(!lista.fin()) {
			int valor = lista.proximo();
			imprimirListaRecursivo(lista);
			System.out.println(valor);
		}
	}

	public static void main(String[] args) {
		var listaEnterosConArreglos = new ListaDeEnterosConArreglos();
		listaEnterosConArreglos.comenzar();
		for (int i = 0; i < 5; i++) {
			listaEnterosConArreglos.agregarFinal(i);
		}
//		for (int i = 0; i < listaEnterosConArreglos.tamanio(); i++) {
//			System.out.println(listaEnterosConArreglos.elemento(i+1));
//		}
		imprimirListaRecursivo(listaEnterosConArreglos);
	}

}
