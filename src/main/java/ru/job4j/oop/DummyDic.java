package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return eng;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String engResponce = word.engToRus("Неизвестное слово. ");
        System.out.println(engResponce + "eng");
    }
}
