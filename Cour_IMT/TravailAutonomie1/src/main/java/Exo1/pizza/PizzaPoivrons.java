package Exo1.pizza;

public class PizzaPoivrons implements Pizza{
    @Override
    public void emballer() {
        System.out.println("Pizza poivrons emballe");
    }
    @Override
    public void couper() {
        System.out.println("Pizza poivrons coupe");
    }
    @Override
    public void cuire() {
        System.out.println("Pizza poivrons cuit");
    }
    @Override
    public void preparer() {
        System.out.println("Pizza poivrons prépare");
    }
}
