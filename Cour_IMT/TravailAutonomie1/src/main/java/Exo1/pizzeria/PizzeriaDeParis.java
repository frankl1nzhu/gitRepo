package Exo1.pizzeria;

import Exo1.pizza.Pizza;
import Exo1.pizza.PizzaParis;

public class PizzeriaDeParis extends Pizzeria {
    @Override
    public Pizza creerPizza(String choix) {
        switch (choix) {
            case "paris": {
                return new PizzaParis();
            }
            default:
                return null;
        }
    }
}
