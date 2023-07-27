/*----------------------------------------------------------------
	FILE		: PointCommon.java
	AUTHOR		: JavaApp1-Mar-2023 Group
	LAST UPDATE	: 29.03.2023

	Friendly Utility class for common point operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.math.geometry;

class PointCommon {

    static double distance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    static double createX(double a, double b, boolean polar)
    {
        return polar ? a * Math.cos(b) : a;
    }

    static double createY(double a, double b, boolean polar)
    {
        return polar ? a * Math.sin(b) : b;
    }

    static String toString(double x, double y)
    {
        return String.format("(%f, %f)", x, y);
    }
}
