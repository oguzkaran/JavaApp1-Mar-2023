/*----------------------------------------------------------
	FILE			: PointCommon.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 27.05.2023

	Friendly class for common operations of Point and MutablePoint

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

class PointCommon {
    private PointCommon()
    {}

    static double distance(double x1, double y1, double x2, double y2)
    {
        return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
    }

    static String toString(double x, double y)
    {
        return String.format("(%.2f, %.2f)", x, y);
    }

    static MutablePoint toMutablePoint(Point point)
    {
        return MutablePoint.ofCartesian(point.getX(), point.getY());
    }

    static Point toPoint(MutablePoint mutablePoint)
    {
        return Point.ofCartesian(mutablePoint.getX(), mutablePoint.getY());
    }
}
