package org.csystem.math;

import org.csystem.math.geometry.Point;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;

@Ignore
public class PointHashCodeTest {
    private final HashSet<Point> m_points = new HashSet<>();
    private final Point m_zero1 = Point.createCartesian(0, 0);
    private final Point m_zero2 = Point.createCartesian(0, 0);
    private final Point m_unit1 = Point.createCartesian(1, 1);
    private final Point m_unit2 = Point.createCartesian(1, 1);
    private final Point m_p1 = Point.createCartesian(-2.1, -3.5);
    private final Point m_p2 = Point.createCartesian(-2.1, -3.5);


    @Test
    public void addValues_thenLookIfContains()
    {
        m_points.add(m_zero1);
        Assert.assertTrue(m_points.contains(m_zero2));
    }

    @Test
    public void addSameValue1_thenReturnFalse()
    {
        m_points.add(m_unit1);
        Assert.assertFalse(m_points.add(m_unit2));
    }

    @Test
    public void addSameValue2_thenReturnFalse()
    {
        m_points.add(m_p1);
        Assert.assertFalse(m_points.add(m_p2));
    }

}

