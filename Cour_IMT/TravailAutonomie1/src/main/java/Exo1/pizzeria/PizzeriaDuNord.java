package Exo1.pizzeria;

import Exo1.pizza.Pizza;
import Exo1.pizza.PizzaFrite;

public class PizzeriaDuNord extends Pizzeria{
    @Override
    public Pizza creerPizza(String choix) {
        switch (choix) {
            case "frite": {
                return new PizzaFrite();
            }
            default:
                return null;
        }
    }
}
