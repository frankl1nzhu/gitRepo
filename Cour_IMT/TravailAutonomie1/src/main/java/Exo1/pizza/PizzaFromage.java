package Exo1.pizza;

public class PizzaFromage implements Pizza{
    @Override
    public void emballer() {
        System.out.println("Pizza fromage emballe");
    }
    @Override
    public void couper() {
        System.out.println("Pizza fromage coupe");
    }
    @Override
    public void cuire() {
        System.out.println("Pizza fromage cuit");
    }
    @Override
    public void preparer() {
        System.out.println("Pizza fromage prépare");
    }
}
