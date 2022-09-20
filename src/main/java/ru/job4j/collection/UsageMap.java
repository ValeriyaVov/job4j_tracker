package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("lerikvov@mail.ru", "Valeria Vovnenko");
        map.put("riccco23@rambler.ru", "Vladimir Solov'ev");
        map.put("milo@mail.ru", "Elizaveta Larina");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
