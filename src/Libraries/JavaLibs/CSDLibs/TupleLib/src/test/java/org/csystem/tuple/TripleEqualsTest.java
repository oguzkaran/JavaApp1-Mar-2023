package org.csystem.tuple;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class TripleEqualsTest {
    @Test
    public void true_test()
    {
        var triple1 = Triple.of(34, "ankara", "çankaya");
        var triple2 = Triple.of(34, "ankara", "çankaya");

        Assert.assertEquals(triple1, triple2);
    }

    @Test
    public void false_test()
    {
        var triple1 = Triple.of(34, "ankara", "Çankaya");
        var triple2 = Triple.of(34, "ankara", "çankaya");

        Assert.assertNotEquals(triple1, triple2);
    }

    @Test
    public void false_different_types_test()
    {
        var triple1 = Triple.of(34, "ankara", 312);
        var triple2 = Triple.of(34, "ankara", "çankaya");

        Assert.assertNotEquals(triple1, triple2);
    }
}
