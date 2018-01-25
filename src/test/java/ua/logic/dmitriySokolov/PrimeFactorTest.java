package ua.logic.dmitriySokolov;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorTest {
    @Test
    public void simple() {
        List<Integer> result = PrimeFactor.getPrimeFactor(12);
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(2);
        expected.add(2);

        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void simple1() {
        List<Integer> result = PrimeFactor.getPrimeFactor(14);
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(2);

        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void simple2() {
        List<Integer> result = PrimeFactor.getPrimeFactor(7);
        List<Integer> expected = new ArrayList<>();
        expected.add(7);

        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void error3() {
        List<Integer> result = PrimeFactor.getPrimeFactor(2);
        List<Integer> expected = new ArrayList<>();
        expected.add(2);

        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void error() {
        List<Integer> result = PrimeFactor.getPrimeFactor(0);
        List<Integer> expected = new ArrayList<>();

        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void error1() {
        List<Integer> result = PrimeFactor.getPrimeFactor(1);
        List<Integer> expected = new ArrayList<>();

        Assert.assertTrue(result.equals(expected));
    }

    @Test()
    public void big() {
        List<Integer> result = PrimeFactor.getPrimeFactor(12460);
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(5);
        expected.add(2);
        expected.add(2);
        expected.add(89);

        Assert.assertTrue(result.equals(expected));
    }

    @Test()
    public void big1() {
        List<Integer> result = PrimeFactor.getPrimeFactor(Integer.MAX_VALUE);
        List<Integer> expected = new ArrayList<>();
        expected.add(Integer.MAX_VALUE);

        Assert.assertTrue(result.equals(expected));
    }


}