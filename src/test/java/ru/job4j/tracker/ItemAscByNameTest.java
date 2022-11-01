package ru.job4j.tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class ItemAscByNameTest {

    @Test
    void whenCompareAsc() {
        List<Item> items = Arrays.asList(
                new Item("Reboot server"),
                new Item("Fix bugs"),
                new Item("Impl task"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Fix bugs"),
                new Item("Impl task"),
                new Item("Reboot server"));
        Assertions.assertEquals(items, expected);
    }
}