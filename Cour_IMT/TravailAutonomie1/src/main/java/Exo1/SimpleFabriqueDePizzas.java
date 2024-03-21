package Exo1;

import Exo1.pizza.Pizza;
import Exo1.pizza.PizzaFromage;
import Exo1.pizza.PizzaGrecque;
import Exo1.pizza.PizzaPoivrons;

public class SimpleFabriqueDePizzas {
    public Pizza creerPizza(String type) {
        Pizza pizza = null;
        if (type.equals("fromage")) {
            pizza = new PizzaFromage();
        } else if (type.equals("poivrons")) {
            pizza = new PizzaPoivrons();
        } else if (type.equals("grecque")) {
            pizza = new PizzaGrecque();
        }
        return pizza;
    }
}
