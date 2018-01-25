package ua.logic.dmitriySokolov;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class AnagramTest {
    @Test
    public void simple() {
        Set<String> expected = new HashSet<>();
        expected.add("act");
        expected.add("atc");
        expected.add("tac");
        expected.add("tca");
        expected.add("cta");

        Assert.assertTrue(expected == Anagram.getCombination("cat"));
    }

    @Test
    public void empty() {
        Set<String> expected = new HashSet<>();

        Assert.assertTrue(expected == Anagram.getCombination("cc"));
    }

    @Test
    public void emptyParameter() {
        Set<String> expected = new HashSet<>();

        Assert.assertTrue(expected == Anagram.getCombination(""));
    }

    @Test
    public void doubleSymbols() {
        Set<String> expected = new HashSet<>();
        expected.add("acc");
        expected.add("cac");

        Assert.assertTrue(expected == Anagram.getCombination("cca"));
    }
}