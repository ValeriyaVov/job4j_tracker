package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.poly.ConsoleInput;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

public class StartUITest {

    @Test
    public void createItem() {
        String[] answers = {"test"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("test");
        assertThat(created.getName(), is(expected.getName()));
    }
}