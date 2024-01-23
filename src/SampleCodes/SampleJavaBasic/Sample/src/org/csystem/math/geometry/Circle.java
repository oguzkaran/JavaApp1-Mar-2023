/*----------------------------------------------------------
	FILE			: Circle.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 22.07.2023

	Circle class that represents a circle

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Circle {
    private static final double DELTA = 0.00001;
    private double m_radius;

    public Circle()
    {
    }

    public Circle(double radius)
    {
        setRadius(radius);
    }

    public double getRadius()
    {
        return m_radius;
    }

    public void setRadius(double radius)
    {
        if (radius < 0)
            throw new IllegalArgumentException(String.format("Radius can not be negative!...->%f", radius));

        m_radius = radius;
    }

    public double getArea()
    {
        return PI * m_radius * m_radius;
    }

    public double getCircumference()
    {
        return 2 * PI * m_radius;
    }

    public boolean equals(Object other)
    {
        return other instanceof Circle c && abs(m_radius - c.m_radius) < DELTA;
    }

    public String toString()
    {
        return String.format("Radius:%f, Area:%f, Circumference:%f", m_radius, getArea(), getCircumference());
    }
}
