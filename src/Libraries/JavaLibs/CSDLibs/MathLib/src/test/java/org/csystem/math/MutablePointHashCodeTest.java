package org.csystem.math;

import org.csystem.math.geometry.MutablePoint;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;

@Ignore
public class MutablePointHashCodeTest {
    private final HashSet<MutablePoint> m_mutablePoints = new HashSet<>();
    private final MutablePoint m_zero1 = MutablePoint.createCartesian(0, 0);
    private final MutablePoint m_zero2 = MutablePoint.createCartesian(0, 0);
    private final MutablePoint m_unit1 = MutablePoint.createCartesian(1, 1);
    private final MutablePoint m_unit2 = MutablePoint.createCartesian(1, 1);
    private final MutablePoint m_mp1 = MutablePoint.createCartesian(-2.1, -3.5);
    private final MutablePoint m_mp2 = MutablePoint.createCartesian(-2.1, -3.5);


    @Test
    public void addValues_thenLookIfContains()
    {
        m_mutablePoints.add(m_zero1);
        Assert.assertTrue(m_mutablePoints.contains(m_zero2));
    }

    @Test
    public void addSameValue1_thenReturnFalse()
    {
        m_mutablePoints.add(m_unit1);
        Assert.assertFalse(m_mutablePoints.add(m_unit2));
    }

    @Test
    public void addSameValue2_thenReturnFalse()
    {
        m_mutablePoints.add(m_mp1);
        Assert.assertFalse(m_mutablePoints.add(m_mp2));
    }

}

