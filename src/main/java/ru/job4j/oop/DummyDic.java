package ru.job4j.oop;

public class DummyDic {

    public String engToRus() {
        String eng = "Adventure";
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String engResponce = word.engToRus();
        System.out.println(engResponce);
    }
}
