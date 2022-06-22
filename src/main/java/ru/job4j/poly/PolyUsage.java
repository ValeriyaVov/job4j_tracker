package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle trailer = new Bus();
        Vehicle train = new Train();
        Vehicle trolley = new Train();
        Vehicle airplane = new Airplane();
        Vehicle helicopter = new Airplane();

        Vehicle[] vehicles = new Vehicle[]{bus, train, airplane, trolley, trailer, helicopter};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
