package ru.job4j.inheritance;

import ru.job4j.inheritance.Pizza;

public class PizzaExtraCheese extends Pizza {
    private static final String CHEESE = " + extra cheese";

        @Override
    public String name() {
        return super.name() + CHEESE;
    }
}
