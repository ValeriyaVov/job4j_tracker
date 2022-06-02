package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 464);
        Book learningJava = new Book("Learning Java", 717);
        Book algoritms = new Book("Algoritms", 288);
        Book sql = new Book("SQL", 316);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = learningJava;
        books[2] = algoritms;
        books[3] = sql;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }

        System.out.println("Swap places books \"Clean code\" and \"SQL\"");
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }

        System.out.println("Show a book with the name: \"Clean code\" ");
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }
}
