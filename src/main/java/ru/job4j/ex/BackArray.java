package ru.job4j.ex;

import java.util.Arrays;

public class BackArray {
    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Nik", "Vasya"};
        for (int index = 0; index < names.length; index++) {
            String temp = names[index];
            names[index] = names[names.length - 1];
            names[names.length - 1] = temp;
        }
        System.out.println(Arrays.toString(names));
    }
}
