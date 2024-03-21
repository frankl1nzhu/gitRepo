package Exo1.pizzeria;

import Exo1.pizza.Pizza;

public abstract class Pizzeria {
    public Pizza commanderPizza(String type) {
        Pizza pizza;
        pizza = creerPizza(type);
        pizza.preparer();
        pizza.cuire();
        pizza.couper();
        pizza.emballer();
        return pizza;
    }
    public abstract Pizza creerPizza(String choix);
}
