package ua.logic.agileEngine;

public class SearchSubstring {
    public static void main(String[] args) {
        String sub = "in";
        String fullString = "in asd dd in d";
        System.out.println(fullString.lastIndexOf(sub));
        System.out.println(lastIndexOf(fullString, sub));
    }

    public static int lastIndexOf(String fullString, String subString) {
        final int lengthFullString = fullString.length();
        final int lengthSubString = subString.length();
        if (lengthSubString == 0) {
            return lengthFullString;
        }
        if (lengthFullString == 0) {
            return -1;
        }

        int countMatches = lengthSubString;
        for (int i = lengthFullString - 1, j = lengthSubString - 1; i >= 0; i--) {
            if (fullString.charAt(i) == subString.charAt(j)) {
                countMatches--;
                j--;
            } else {
                countMatches = subString.length();
                j = lengthSubString - 1;
            }
            if (countMatches == 0) {
                return i;
            }
        }

        return -1;
    }
}
