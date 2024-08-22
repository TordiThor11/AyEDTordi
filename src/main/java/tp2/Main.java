package tp2;

public class Main {
    public static void main(String[] args) {
        var recorredor = new RecorridosAG();
        ArbolGeneral<Integer> arbolGeneral = new ArbolGeneral<Integer>(10);
        arbolGeneral.agregarHijo(new ArbolGeneral<Integer>(5));
        arbolGeneral.agregarHijo(new ArbolGeneral<>(15));
        recorredor.recorrerPreOrder(arbolGeneral);
    }
}
