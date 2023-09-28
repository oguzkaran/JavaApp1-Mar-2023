package org.csystem.math;

import org.csystem.math.factory.RandomCircleFactory;
import org.csystem.math.geometry.AnalyticalCircle;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

@Ignore
public class AnalyticalCircleEqualsTest {

    @Test
    public void fillValuesLastZero_thenFindZero()
    {

        var analyticalCircles = new ArrayList<AnalyticalCircle>();
        var factory = new RandomCircleFactory(new Random());

        while (true) {
            var ac = factory.createAnalyticalCircle(-10, 10);

            analyticalCircles.add(ac);
            if (ac.getRadius() == 0 && ac.getX() == 0 && ac.getY() == 0)
                break;
        }


        var zero = new AnalyticalCircle();
        var index = analyticalCircles.indexOf(zero);

        Assert.assertEquals(index, analyticalCircles.size() - 1);
    }
}
