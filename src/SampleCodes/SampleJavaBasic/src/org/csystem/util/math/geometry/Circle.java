/*----------------------------------------------------------------------
	FILE        : Circle.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 09.10.2021

	Circle class that represents the circle in geometry

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math.geometry;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Circle {
    private double m_r;

    public Circle()
    {}

    public Circle(double r)
    {
        setRadius(r);
    }

    public double getRadius()
    {
        return m_r;
    }

    public void setRadius(double r)
    {
        m_r = abs(r);
    }

    public double getArea()
    {
        return PI * m_r * m_r;
    }

    public double getCircumference()
    {
        return 2 * PI * m_r;
    }
}
