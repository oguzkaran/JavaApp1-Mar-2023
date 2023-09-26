package org.csystem.math;

import org.csystem.math.factory.RandomPointFactory;
import org.csystem.math.geometry.MutablePoint;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

@Ignore
public class MutablePointEqualsTest {

    @Test
    public void fillValuesLastOrigin_thenFindOrigin()
    {
        var points = new ArrayList<MutablePoint>();
        var factory = new RandomPointFactory(new Random());

        while (true) {
            var p = factory.createMutablePoint(-10, 10);

            points.add(p);

            if (p.getX() == 0 && p.getY() == 0)
                break;
        }

        var origin = MutablePoint.createCartesian();
        var index = points.indexOf(origin);

        Assert.assertEquals(index, points.size() - 1);
    }
}
