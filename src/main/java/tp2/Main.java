package tp2;

public class Main {
    public static void main(String[] args) {
        var recorredor = new RecorridosAG();
        ArbolGeneral<Integer> arbolGeneral = new ArbolGeneral<Integer>(10);

        ArbolGeneral<Integer> arbolGeneral2 = new ArbolGeneral<Integer>(11);
        arbolGeneral2.agregarHijo(new ArbolGeneral<Integer>(5));

        arbolGeneral.agregarHijo(arbolGeneral2);
        arbolGeneral.agregarHijo(new ArbolGeneral<>(15));
        recorredor.recorrerPreOrder(arbolGeneral);
        //EN PRE-ORDER --> 10 - 11 - 5 - 15

        
    }
}
