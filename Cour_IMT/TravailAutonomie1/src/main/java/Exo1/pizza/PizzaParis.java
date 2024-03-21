package Exo1.pizza;

public class PizzaParis implements Pizza{
    @Override
    public void emballer() {
        System.out.println("Pizza paris emballe");
    }
    @Override
    public void couper() {
        System.out.println("Pizza paris coupe");
    }
    @Override
    public void cuire() {
        System.out.println("Pizza paris cuit");
    }
    @Override
    public void preparer() {
        System.out.println("Pizza paris prépare");
    }
}
