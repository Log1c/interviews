package ua.logic.betinvest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BoundedMemorizedTest {
    @Test
    public void getCache() {
        BoundedMemorized compute = new BoundedMemorized(3);

        Assert.assertTrue(compute.sum(1, 1) == 2.0);
        Assert.assertTrue(compute.getCache().size() == 1);
        Assert.assertTrue(compute.getCache().containsValue(2.0));

        compute.sum(1, 2);
        Assert.assertTrue(compute.getCache().size() == 2);
        Assert.assertTrue(compute.getCache().containsValue(3.0));

        compute.sum(1, 3);
        Assert.assertTrue(compute.getCache().size() == 3);
        Assert.assertTrue(compute.getCache().containsValue(4.0));

        compute.sum(1, 1);
        Assert.assertTrue(compute.getCache().size() == 3);
        Assert.assertTrue(compute.getCache().containsValue(2.0));

        compute.sum(1, 3);
        Assert.assertTrue(compute.getCache().size() == 3);
        Assert.assertTrue(compute.getCache().containsValue(4.0));

        compute.sum(1, 4);
        Assert.assertTrue(compute.getCache().size() == 3);
        Assert.assertTrue(compute.getCache().containsValue(5.0));
        Assert.assertFalse(compute.getCache().containsValue(3.0));

        compute.sum(1, 1);
        Assert.assertTrue(compute.getCache().size() == 3);
        Assert.assertTrue(compute.getCache().containsValue(2.0));
    }

    @Test
    public void getConcurrentCache() {
        BoundedMemorized compute = new BoundedMemorized(3);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> compute.sum(1, 1));
            threads.add(thread);
            thread.start();
        }
        boolean flag = true;
        while (flag) {
            for (Thread thread : threads) {
                flag = thread.isAlive();
                if (flag) {
                    break;
                }
            }
        }
        Assert.assertTrue(compute.getCache().size() == 1);
        Assert.assertTrue(compute.getCache().containsValue(2.0));
    }
}