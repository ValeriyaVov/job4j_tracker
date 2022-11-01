package ru.job4j.tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ItemDescByNameTest {

    @Test
    void whenCompareDesc() {
        List<Item> items = Arrays.asList(
                new Item("Reboot server"),
                new Item("Fix bugs"),
                new Item("Impl task"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Reboot server"),
                new Item("Impl task"),
                new Item("Fix bugs"));
        Assertions.assertEquals(items, expected);
    }
}