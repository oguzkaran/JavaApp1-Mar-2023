package org.csystem.math;

import org.csystem.math.geometry.AnalyticalCircle;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;

@Ignore
public class AnalyticalCircleHashCodeTest {
    private final HashSet<AnalyticalCircle> m_analyticalCircles = new HashSet<>();
    private final AnalyticalCircle m_zero1 = new AnalyticalCircle();
    private final AnalyticalCircle m_zero2 = new AnalyticalCircle();
    private final AnalyticalCircle m_unit1 = new AnalyticalCircle(1, 1, 1);
    private final AnalyticalCircle m_unit2 = new AnalyticalCircle(1, 1, 1);
    private final AnalyticalCircle m_ac1 = new AnalyticalCircle(2, -3.5, -2.2);
    private final AnalyticalCircle m_ac2 = new AnalyticalCircle(2, -3.5, -2.2);

    @Test
    public void addValues_thenLookIfContains()
    {
        m_analyticalCircles.add(m_zero1);
        Assert.assertTrue(m_analyticalCircles.contains(m_zero2));
    }

    @Test
    public void addSameValue1_thenReturnFalse()
    {
        m_analyticalCircles.add(m_unit1);
        Assert.assertFalse(m_analyticalCircles.add(m_unit2));
    }

    @Test
    public void addSameValue2_thenReturnFalse()
    {
        m_analyticalCircles.add(m_ac1);
        Assert.assertFalse(m_analyticalCircles.add(m_ac2));
    }
}

