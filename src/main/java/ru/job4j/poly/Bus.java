package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("The bus is coming");
    }

    @Override
    public void passengers(int quantity) {
        int count = quantity;
    }

    @Override
    public int refuel(int count) {
        int price = 50;
        return price * count;
    }
}
