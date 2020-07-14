package ua.logic.techStack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreesAndSunTest {

    @Test
    public void getSunnyTrees() {
        TreesAndSun sun = new TreesAndSun();
        List<Integer> trees = Arrays.asList(1, 2, 4, 3);

        List<Integer> expected = Arrays.asList(0, 1, 2);

        Assert.assertEquals(expected, sun.getSunnyTrees(trees));
    }

    @Test
    public void getSunnyTreesEmpty() {
        TreesAndSun sun = new TreesAndSun();
        List<Integer> trees = new ArrayList<>();

        List<Integer> expected = new ArrayList<>();

        Assert.assertEquals(expected, sun.getSunnyTrees(trees));
    }

    @Test
    public void getSunnyTreesOne() {
        TreesAndSun sun = new TreesAndSun();
        List<Integer> trees = Collections.singletonList(1);

        List<Integer> expected = Collections.singletonList(0);

        Assert.assertEquals(expected, sun.getSunnyTrees(trees));
    }

    @Test
    public void getSunnyTreesAll() {
        TreesAndSun sun = new TreesAndSun();
        List<Integer> trees = Arrays.asList(1, 2, 3, 4);

        List<Integer> expected = Arrays.asList(0, 1, 2, 3);

        Assert.assertEquals(expected, sun.getSunnyTrees(trees));
    }
}