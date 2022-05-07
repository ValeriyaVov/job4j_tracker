package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        int result2 = minus(25);
        System.out.println(result2);
        Calculator divNum = new Calculator();
        System.out.println(divNum.divide(25));
        Calculator sumAll = new Calculator();
        System.out.println(sumAll.sumAllOperation(5));

    }
}
