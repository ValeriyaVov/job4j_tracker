package ru.job4j.ex;

public class Find {
    public static String get(String[] data, int index) throws IllegalAccessException {
        if (index < 0 || index >= data.length) {
            throw new IllegalAccessException("Index out of bound");
        }
        return data[index];
    }

    public static void main(String[] args) throws IllegalAccessException {
        String[] data = {"one", "two", "three"};
        String rsl = Find.get(data, 0);
        System.out.println(rsl);
    }
}
