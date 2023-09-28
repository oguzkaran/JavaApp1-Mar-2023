package org.csystem.math;

import org.csystem.math.factory.RandomCircleFactory;
import org.csystem.math.geometry.Circle;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

@Ignore
public class CircleEqualsTest {
    @Test
    public void fillValuesLastZero_thenFindZero()
    {

        var circles = new ArrayList<Circle>();
        var factory = new RandomCircleFactory(new Random());

        while (true) {
            var c = factory.createCircle(-10, 1);

            circles.add(c);
            if (c.getRadius() == 0)
                break;
        }

        var zero = new Circle();
        var index = circles.indexOf(zero);

        Assert.assertEquals(index, circles.size() - 1);
    }
}
