package org.csystem.math;

import org.csystem.math.factory.RandomComplexFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class ComplexEqualsTest {

    @Test
    public void fillValuesLastZero_thenFindZero()
    {
        var numbers = new ArrayList<Complex>();
        var factory = new RandomComplexFactory(new Random());

        while (true) {
            var z = factory.create(-10, 10);

            numbers.add(z);

            if (z.getReal() == 0 && z.getImag() == 0)
                break;
        }

        var zero = new Complex();
        var index = numbers.indexOf(zero);

        Assert.assertEquals(index, numbers.size() - 1);
    }
}
