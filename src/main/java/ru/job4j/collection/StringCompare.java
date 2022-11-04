package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int l = left.length();
        int r = right.length();
        int rsl = 0;
        for (int i = 0; i < left.length(); i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        rsl = Integer.compare(l, r);
        return rsl;
    }
}
