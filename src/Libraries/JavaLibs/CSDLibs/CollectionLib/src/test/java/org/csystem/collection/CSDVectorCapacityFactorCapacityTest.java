package org.csystem.collection;

import org.csystem.range.IntRange;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class CSDVectorCapacityFactorCapacityTest {
    @Test
    public void intValueTest()
    {
        var vec = new CSDVectorCapacityFactor<Integer>(10, 3);

        IntRange.ofClosed(1, 11).forEach(vec::add);

        assertEquals(30, vec.capacity());
    }

    @Test
    public void doubleValueTest()
    {
        var vec = new CSDVectorCapacityFactor<Integer>(10, 3.5);

        IntRange.ofClosed(1, 11).forEach(vec::add);

        assertEquals(35, vec.capacity());
    }
}
