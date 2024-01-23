/*----------------------------------------------------------
	FILE			: MutablePoint.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 23.01.2024
	
	MutablePoint class that represents a point in cartesian plane
	
	Copyleft (c) 1993 C and System Programmers Association 
	All Rights Free
------------------------------------------------------------*/
package org.csystem.math.geometry;

import java.io.Serial;
import java.io.Serializable;

import static java.lang.Math.*;

public class MutablePoint implements Serializable {
	@Serial
	private static final long serialVersionUID = -10L;

	private static final double DELTA = 0.000001;
	private double m_x, m_y;

	private MutablePoint(double a, double b, boolean polar)
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

	public static MutablePoint ofCartesian()
	{
		return ofCartesian(0);
	}

	public static MutablePoint ofCartesian(double x)
	{
		return ofCartesian(x, 0);
	}

	public static MutablePoint ofCartesian(double x, double y)
	{
		return new MutablePoint(x, y, false);
	}

	public static MutablePoint ofPolar(double radius, double theta)
	{
		return new MutablePoint(radius, theta, true);
	}

	public double getX()
	{
		return m_x;
	}

	public void setX(double x)
	{
		m_x = x;
	}

	public double getY()
	{
		return m_y;
	}

	public void setY(double y)
	{
		m_y = y;
	}

	public double distance()
	{
		return distance(0, 0);
	}
	
	public double distance(double x, double y)
	{
		return PointCommon.distance(m_x, m_y, x, y);
	}
	
	public double distance(MutablePoint other)
	{
		return distance(other.m_x, other.m_y);
	}
	
	public void offset(double dxy)
	{
		offset(dxy, dxy);
	}
	
	public void offset(double dx, double dy)
	{
		m_x += dx;
		m_y += dy;
	}

	public boolean equals(Object other)
	{
		return other instanceof MutablePoint p && abs(m_x - p.m_x) < DELTA && abs(m_y - p.m_y) < DELTA;
	}
	public String toString()
	{
		return PointCommon.toString(m_x, m_y);
	}
}
