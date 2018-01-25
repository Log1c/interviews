package ua.logic.agileEngine;

import java.util.*;

public class Anagram {
    public static List<String> getAnagrams(String raw) {
        String[] splited = raw.split(" ");
        Map<String, String> map = new LinkedHashMap<>();
        for (String s : splited) {
            String sortedString = sort(s);
            map.merge(sortedString, s, (k, v) -> k + " " + s);
        }

        return new ArrayList<>(map.values());
    }

    private static String sort(String string) {
        char[] a = string.toCharArray();
        Arrays.sort(a);

        return new String(a);
    }
}
