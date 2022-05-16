package ru.job4j.inheritance;

import ru.job4j.inheritance.Pizza;
import ru.job4j.inheritance.PizzaExtraCheese;
import ru.job4j.inheritance.PizzaExtraCheeseExtraTomato;

public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("name1 :");
        PizzaExtraCheese pizzaExtraCheese = new PizzaExtraCheese("name2 :");
        PizzaExtraCheeseExtraTomato pizzaExtraCheeseExtraTomato = new PizzaExtraCheeseExtraTomato("name3 :");
        System.out.println(pizza.name());
        System.out.println(pizzaExtraCheese.name());
        System.out.println(pizzaExtraCheeseExtraTomato.name());
    }
}
