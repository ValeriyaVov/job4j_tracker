package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load -= this.load;
    }

    public static void main(String[] args) {
        Battery first = new Battery(6);
        Battery second = new Battery(3);
        System.out.println("Battery first:" + first.load + "Battery second:" + second.load );
        second.exchange(first);
        System.out.println("Battery first:" + first.load + "Battery second:" + second.load );
    }
}
