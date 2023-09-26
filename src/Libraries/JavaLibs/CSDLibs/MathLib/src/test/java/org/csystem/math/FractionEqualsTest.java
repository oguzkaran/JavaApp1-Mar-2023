package org.csystem.math;

import org.csystem.math.factory.RandomFractionFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

@Ignore
public class FractionEqualsTest {

    @Test
    public void fillValuesLastOne_thenFindOne()
    {
        var fractions = new ArrayList<Fraction>();
        var factory = new RandomFractionFactory(new Random());

        while (true) {
            try {
                var fraction = factory.create(-100, 100);

                fractions.add(fraction);

                if (fraction.getNumerator() == 1 && fraction.getDenominator() == 1)
                    break;
            }
            catch (NumberFormatException ignore) {

            }
        }

        var one = new Fraction(1);
        var index = fractions.indexOf(one);

        Assert.assertEquals(index, fractions.size() - 1);
    }
}
