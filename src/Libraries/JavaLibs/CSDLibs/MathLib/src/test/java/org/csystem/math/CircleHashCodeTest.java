package org.csystem.math;

import org.csystem.math.geometry.Circle;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import java.util.HashSet;

@Ignore
public class CircleHashCodeTest {
    private final HashSet<Circle> m_circles = new HashSet<>();
    private final Circle m_zero1 = new Circle();
    private final Circle m_zero2 = new Circle();
    private final Circle m_unit1 = new Circle(1);
    private final Circle m_unit2 = new Circle(1);
    private final Circle m_c1 = new Circle(2.1);
    private final Circle m_c2 = new Circle(2.1);

    @Test
    public void addValues_thenLookIfContains()
    {
        m_circles.add(m_zero1);
        Assert.assertTrue(m_circles.contains(m_zero2));
    }

    @Test
    public void addSameValue1_thenReturnFalse()
    {
        m_circles.add(m_unit1);
        Assert.assertFalse(m_circles.add(m_unit2));
    }

    @Test
    public void addSameValue2_thenReturnFalse()
    {
        m_circles.add(m_c1);
        Assert.assertFalse(m_circles.add(m_c2));
    }
}

