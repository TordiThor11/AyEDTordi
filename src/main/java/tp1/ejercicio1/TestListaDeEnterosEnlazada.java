package tp1.ejercicio1;

public class TestListaDeEnterosEnlazada {

	public static void main(String[] args) {
		var listaEnterosEnlazada = new ListaDeEnterosEnlazada();
		listaEnterosEnlazada.comenzar();
		for (int i = 0; i < 5; i++) {
			listaEnterosEnlazada.agregarFinal(i);
		}
		for (int i = 0; i < listaEnterosEnlazada.tamanio(); i++) {
			System.out.println(listaEnterosEnlazada.elemento(i+1));
		}

	}

}
