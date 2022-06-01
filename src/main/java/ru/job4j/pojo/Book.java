package ru.job4j.pojo;

public class Book {
    private String name;
    private int count;

    public Book(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Book otherBook = (Book) obj;
        return otherBook.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
