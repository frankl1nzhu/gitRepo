package Exo1.pizza;

public class PizzaGrecque implements Pizza{
    @Override
    public void emballer() {
        System.out.println("Pizza grecque emballe");
    }
    @Override
    public void couper() {
        System.out.println("Pizza grecque coupe");
    }
    @Override
    public void cuire() {
        System.out.println("Pizza grecque cuit");
    }
    @Override
    public void preparer() {
        System.out.println("Pizza grecque prépare");
    }
}
