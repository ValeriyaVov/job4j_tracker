package ru.job4j.tracker;

public class SingleTracker {

    private static SingleTracker instance = null;

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    private Tracker tracker = new Tracker();

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return null;
    }
    
    public Item findAll() {
        return null;
    }
    
    public Item findByName(String key) {
        return null;
    }

    public Item replace(int id, Item item) {
        return null;
    }

    public Item delete(int id) {
        return null;
    }
}
