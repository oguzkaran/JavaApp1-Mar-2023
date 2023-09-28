package org.csystem.tuple;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PairEqualsTest {
    @Test
    public void true_test()
    {
        var pair1 = Pair.of("ankara", "istanbul");
        var pair2 = Pair.of("ankara", "istanbul");

        Assert.assertEquals(pair1, pair2);
    }

    @Test
    public void false_test()
    {
        var pair1 = Pair.of("ankara", "İstanbul");
        var pair2 = Pair.of("ankara", "istanbul");

        Assert.assertNotEquals(pair1, pair2);
    }

    @Test
    public void false_different_types_test()
    {
        var pair1 = Pair.of("ankara", "istanbul");
        var pair2 = Pair.of(34, "istanbul");

        Assert.assertNotEquals(pair1, pair2);
    }
}
