package ua.logic.betinvest;

import org.junit.Assert;
import org.junit.Test;

public class BoundedMemorizedTest {
    @Test
    public void getCache() {
        BoundedMemorized compute = new BoundedMemorized(3);

        compute.sum(1, 1);
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

}