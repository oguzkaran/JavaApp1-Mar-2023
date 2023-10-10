package org.csystem.collection;

import org.csystem.collection.factory.RandomComplexFactory;
import org.csystem.math.Complex;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Random;

@Ignore
public class CSDArrayListIndexOfTest {

    @Test
    public void fillValuesLastZero_thenFindZero()
    {
        var numbers = new CSDArrayList<Complex>();
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
