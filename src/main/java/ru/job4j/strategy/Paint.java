package ru.job4j.strategy;

public class Paint implements Shape {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.draw(new Triangle());
        context.draw(new Square());
    }

    @Override
    public String draw() {
        return null;
    }
}