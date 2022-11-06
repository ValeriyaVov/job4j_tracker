package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int l = extractInt(left);
        int r = extractInt(right);

        return Integer.compare(l, r);
    }

    private static int extractInt(String name) {
        String[] segmentR = name.split("\\. ", 2);
        return Integer.parseInt(segmentR[0]);
    }
}
