package ua.logic.agileEngine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class AnagramTest {
    @Test
    public void smoke() {
        assertTrue(Anagram.getAnagrams("123").equals(new ArrayList<String>(Arrays.asList("123"))));
    }

    @Test
    public void getEmpty() {
        assertTrue(Anagram.getAnagrams("").equals(new ArrayList<String>(Arrays.asList(""))));
    }

    @Test
    public void getSimple() {
        assertTrue(Anagram.getAnagrams("123 312").equals(new ArrayList<String>(Arrays.asList("123 312"))));
    }

    @Test
    public void getSimple2() {
        assertTrue(Anagram.getAnagrams("123 312 433").equals(new ArrayList<>(Arrays.asList("123 312", "433"))));
    }

    @Test
    public void getDifficult() {
        assertTrue(Anagram.getAnagrams("123 3121 22433 33422 33").equals(
                new ArrayList<String>(Arrays.asList("123", "3121", "22433 33422", "33"))));
    }
}