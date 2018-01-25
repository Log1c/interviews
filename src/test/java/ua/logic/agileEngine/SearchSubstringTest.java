package ua.logic.agileEngine;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class SearchSubstringTest {

    @Test
    public void lastIndexOf() {
        String sub = "in";
        String fullString = "in asd dd in d";
        assertTrue(SearchSubstring.lastIndexOf(fullString, sub) == fullString.lastIndexOf(sub));
    }

    @Test
    public void lastIndexOf2() {
        String sub = "";
        String fullString = "in asd dd in d";
        assertTrue(SearchSubstring.lastIndexOf(fullString, sub) == fullString.lastIndexOf(sub));
    }

    @Test
    public void lastIndexOf3() {
        String sub = "";
        String fullString = "";
        assertTrue(SearchSubstring.lastIndexOf(fullString, sub) == fullString.lastIndexOf(sub));
    }

    @Test
    public void lastIndexOf4() {
        String sub = "w";
        String fullString = "s";
        assertTrue(SearchSubstring.lastIndexOf(fullString, sub) == fullString.lastIndexOf(sub));
    }

    @Test
    public void lastIndexOf5() {
        String sub = "wd";
        String fullString = "";
        assertTrue(SearchSubstring.lastIndexOf(fullString, sub) == fullString.lastIndexOf(sub));
    }
}