package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ShowAllActionTest {

   @Test
   public void whenShowAllItemTestOutputIsSuccessfully() {
       Output out = new StubOutput();
       Tracker tracker = new Tracker();
       Item one = tracker.add(new Item("test1"));
       Input in = new StubInput(
               new String[] {"0", String.valueOf(one.getId()), "1"}
       );
       ArrayList<UserAction> actions = new ArrayList<>();
       actions.add(new ShowAllAction(out));
       actions.add(new ExitAction(out));
       new StartUI(out).init(in, tracker, actions);
       String ln = System.lineSeparator();
       assertThat(out.toString(), is(
               "Menu:" + ln
                       + "0. Show all items" + ln
                       + "1. Exit Program" + ln
                       + "=== Show all items ===" + ln
                       + one + ln
                       + "Menu:" + ln
                       + "0. Show all items" + ln
                       + "1. Exit Program" + ln
                       + "=== Exit Program ===" + ln
       ));
   }
}