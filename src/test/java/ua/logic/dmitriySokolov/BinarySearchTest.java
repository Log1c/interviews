package ua.logic.dmitriySokolov;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    final static int NOT_FOUND = -1;

    @Test
    public void lessFoundInUnEven() {
        int[] ints = {10, 20, 30};
        Assert.assertTrue(0 == BinarySearch.search(ints, 10));
    }

    @Test
    public void middleFoundInUnEven() {
        int[] ints = {10, 20, 30};
        Assert.assertTrue(1 == BinarySearch.search(ints, 20));
    }

    @Test
    public void highFoundInUnEven() {
        int[] ints = {10, 20, 30};
        Assert.assertTrue(2 == BinarySearch.search(ints, 30));
    }

    @Test
    public void lessFoundInEven() {
        int[] ints = {10, 20, 30, 40};
        Assert.assertTrue(0 == BinarySearch.search(ints, 10));
    }

    @Test
    public void middleFoundInEven() {
        int[] ints = {10, 20, 30, 40};
        Assert.assertTrue(2 == BinarySearch.search(ints, 30));
    }

    @Test
    public void highFoundInEven() {
        int[] ints = {10, 20, 30, 40};
        Assert.assertTrue(3 == BinarySearch.search(ints, 40));
    }

    @Test
    public void lessNotFoundInUnEven() {
        int[] ints = {10, 20, 30};
        Assert.assertTrue(NOT_FOUND == BinarySearch.search(ints, -1));
    }

    @Test
    public void middleNotFoundInUnEven() {
        int[] ints = {10, 20, 30};
        Assert.assertTrue(NOT_FOUND == BinarySearch.search(ints, 21));
    }

    @Test
    public void highNotFoundInUnEven() {
        int[] ints = {10, 20, 30};
        Assert.assertTrue(NOT_FOUND == BinarySearch.search(ints, 40));
    }

    @Test
    public void lessNotFoundInEven() {
        int[] ints = {10, 20, 30, 40};
        Assert.assertTrue(NOT_FOUND == BinarySearch.search(ints, 5));
    }

    @Test
    public void middleNotFoundInEven() {
        int[] ints = {10, 20, 30, 40};
        Assert.assertTrue(NOT_FOUND == BinarySearch.search(ints, 25));
    }

    @Test
    public void highNotFoundInEven() {
        int[] ints = {10, 20, 30, 40};
        Assert.assertTrue(NOT_FOUND == BinarySearch.search(ints, 50));
    }

    @Test
    public void Performance() {
        final int max = Integer.MAX_VALUE/7;
        int[] ints = new int[max];
        for (int i = 0; i < max; i++) {
            ints[i] = i;
        }

        Assert.assertTrue(max/2 == BinarySearch.search(ints, max/2));
    }
}