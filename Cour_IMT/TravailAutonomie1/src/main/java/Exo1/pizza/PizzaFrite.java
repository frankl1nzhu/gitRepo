package Exo1.pizza;

public class PizzaFrite implements Pizza{
    @Override
    public void emballer() {
        System.out.println("Pizza frite emballe");
    }
    @Override
    public void couper() {
        System.out.println("Pizza frite coupe");
    }
    @Override
    public void cuire() {
        System.out.println("Pizza frite cuit");
    }
    @Override
    public void preparer() {
        System.out.println("Pizza frite prépare");
    }
}
