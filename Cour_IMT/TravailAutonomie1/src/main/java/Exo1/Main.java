package Exo1;

import Exo1.pizzeria.Pizzeria;
import Exo1.pizzeria.PizzeriaDeParis;
import Exo1.pizzeria.PizzeriaDuNord;

public class Main {
    public static void main(String[] args) {
        SimpleFabriqueDePizzas fabrique = new SimpleFabriqueDePizzas();
        Pizzeria pizzeriaDuNord = new PizzeriaDuNord();
        pizzeriaDuNord.creerPizza("frite");
        pizzeriaDuNord.commanderPizza("frite");

        System.out.println("*************************");

        Pizzeria pizzeriaDeParis = new PizzeriaDeParis();
        pizzeriaDeParis.creerPizza("paris");
        pizzeriaDeParis.commanderPizza("paris");

    }
}
