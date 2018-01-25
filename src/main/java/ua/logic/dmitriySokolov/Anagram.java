package ua.logic.dmitriySokolov;

import java.util.HashSet;
import java.util.Set;

//TODO don't work
public class Anagram {
    public static Set<String> getCombination(String text) {
        Set<String> result = new HashSet<>();
        result.add(text);
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result.addAll(getVariant(chars, i));
        }
//        for (char c : chars) {
//            String variant =
//        }
        return result;
    }

    private static Set<String> getVariant(char[] chars, int positionCurrentSymbol) {
        Set<String> result = new HashSet<>();
//        while (true) {
        for (int i = 0; i < chars.length; i++) {
            String variant = "";
            for (int j = 0; j < chars.length; j++) {
                variant += chars[j];
            }
            result.add(variant);
        }
//        }

        return result;
    }
}
