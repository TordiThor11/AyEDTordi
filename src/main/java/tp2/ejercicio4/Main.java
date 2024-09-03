package tp2.ejercicio4;

import tp1.ejercicio2.ListaGenerica;
import tp2.ejercicio3.ArbolGeneral;

public class Main {
    public static void main(String[] args) {
        ArbolGeneral<AreaEmpresa> arbolDeLaEmpresa = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("m", 14));
        //Primer hijo
        ArbolGeneral<AreaEmpresa> arbolJ = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("j", 13));
        arbolJ.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("a", 4)));
        arbolJ.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("b", 7)));
        arbolJ.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("c", 5)));
        arbolDeLaEmpresa.agregarHijo(arbolJ);
        //Segundo hijo
        ArbolGeneral<AreaEmpresa> arbolK = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("k", 25));
        arbolK.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("d", 6)));
        arbolK.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("e", 10)));
        arbolK.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("f", 18)));
        arbolDeLaEmpresa.agregarHijo(arbolK);
        //Tercer hijo
        ArbolGeneral<AreaEmpresa> arbolL = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("l", 10));
        arbolL.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("g", 9)));
        arbolL.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("h", 12)));
        arbolL.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("i", 19)));
        arbolDeLaEmpresa.agregarHijo(arbolL);
        //Imprimo el arbol
        AnalizadorArbol analizadorArbol = new AnalizadorArbol();
        ListaGenerica<AreaEmpresa> listaPorNiveles = analizadorArbol.recorridoPorNiveles(arbolDeLaEmpresa);
        System.out.println("Tamanio de la lista por niveles: " + listaPorNiveles.tamanio());
        listaPorNiveles.comenzar();
        while (!listaPorNiveles.fin()) {
            System.out.println(listaPorNiveles.proximo().toString());
        }
        //Prueba modulo retornarMayor

    }
}
