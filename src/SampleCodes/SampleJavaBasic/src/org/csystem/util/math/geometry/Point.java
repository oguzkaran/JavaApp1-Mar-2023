/*----------------------------------------------------------------------
	FILE        : Point.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 14.11.2021

	Point class that represents the 2(two) dimensional point

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math.geometry;

import static java.lang.Math.sqrt;

enum CoordinateType {CARTESIAN, POLAR}

public class Point {
	public double x;
	public double y;

	private Point(double x, double y, CoordinateType coordinateType)
	{
		this.x = coordinateType == CoordinateType.CARTESIAN ? x : x * Math.cos(y);
		this.y = coordinateType == CoordinateType.CARTESIAN ? y : y * Math.sin(y);
	}

	Point(Point p)
	{
		x = p.x;
		y = p.y;
	}

	public static Point createCartesian(double x, double y)
	{
		return new Point(x, y, CoordinateType.CARTESIAN);
	}

	public static Point createPolar(double r, double theta)
	{
		return new Point(r, theta, CoordinateType.POLAR);
	}

	public double distance()
	{
		return this.distance(0, 0);
	}

	public double distance(Point other)
	{
		return this.distance(other.x, other.y);
	}

	public double distance(double x, double y)
	{
		return sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
	}

	public void offset(double dxy)
	{
		this.offset(dxy, dxy);
	}

	public void offset(double dx, double dy)
	{
		x += dx;
		y += dy;
	}

	public String toString()
	{
		return String.format("{x: %f, y: %f}", x, y);
	}

	//...
}