/*----------------------------------------------------------
	FILE			: Point.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 23.01.2024
	
	Immutable Point class that represents a point in cartesian plane
	
	Copyleft (c) 1993 C and System Programmers Association 
	All Rights Free
------------------------------------------------------------*/
package org.csystem.math.geometry;

import java.io.Serial;
import java.io.Serializable;

import static java.lang.Math.*;

public class Point implements Serializable {
	@Serial
	private static final long serialVersionUID = -10L;

	private static final double DELTA = 0.00001;
	private final double m_x, m_y;

	private Point(double a, double b, boolean polar)
	{
		if (polar) {
			m_x = a * cos(a);
			m_y = a * sin(a);
		}
		else {
			m_x = a;
			m_y = b;
		}
	}

	public static Point ofCartesian()
	{
		return ofCartesian(0);
	}

	public static Point ofCartesian(double x)
	{
		return ofCartesian(x, 0);
	}

	public static Point ofCartesian(double x, double y)
	{
		return new Point(x, y, false);
	}

	public static Point ofPolar(double radius, double theta)
	{
		return new Point(radius, theta, true);
	}

	public double getX()
	{
		return m_x;
	}

	public double getY()
	{
		return m_y;
	}

	public double distance()
	{
		return distance(0, 0);
	}
	
	public double distance(double x, double y)
	{
		return PointCommon.distance(m_x, m_y, x, y);
	}
	
	public double distance(Point other)
	{
		return distance(other.m_x, other.m_y);
	}

	public boolean equals(Object other)
	{
		return other instanceof Point p && abs(m_x - p.m_x) < DELTA && abs(m_y - p.m_y) < DELTA;
	}
	public String toString()
	{
		return PointCommon.toString(m_x, m_y);
	}
}
