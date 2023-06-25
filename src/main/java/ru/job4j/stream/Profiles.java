package ru.job4j.stream;

import java.util.List;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles
                .stream()
                .map(Profile::getAddress)
                .toList();
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles
                .stream()
                .map(Profile::getAddress)
                .sorted(Address::compareTo)
                .distinct()
                .toList();
    }
}