/*----------------------------------------------------------
	FILE			: Line.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 18.06.2023

	Line class that represents a line in cartesian plane

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.math.geometry;

public class Line {
    private final MutablePoint m_p1, m_p2;

    //...

    public Line(double x1, double y1, double x2, double y2)
    {
        m_p1 = MutablePoint.ofCartesian(x1, y1);
        m_p2 = MutablePoint.ofCartesian(x2, y2);
    }

    public MutablePoint getPoint1()
    {
        return MutablePoint.ofCartesian(m_p1.getX(), m_p1.getY());
    }

    public MutablePoint getPoint2()
    {
        return MutablePoint.ofCartesian(m_p2.getX(), m_p2.getY());
    }

    public double getX1()
    {
        return m_p1.getX();
    }

    public void setX1(double x1)
    {
        m_p1.setX(x1);
    }

    public double getY1()
    {
        return m_p1.getY();
    }

    public void setY1(double y1)
    {
        m_p1.setY(y1);
    }

    public double getX2()
    {
        return m_p2.getX();
    }

    public void setX2(double x2)
    {
        m_p2.setX(x2);
    }

    public void setY2(double y2)
    {
        m_p1.setY(y2);
    }

    public double getY2()
    {
        return m_p2.getY();
    }

    public boolean isInside(Point point)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public Point midPoint()
    {
        return Point.ofCartesian((m_p1.getX() + m_p2.getX()) / 2, (m_p1.getY() + m_p2.getY()) / 2);
    }

    public MutablePoint midMutablePoint()
    {
        return MutablePoint.ofCartesian((m_p1.getX() + m_p2.getX()) / 2, (m_p1.getY() + m_p2.getY()) / 2);
    }

    public String toString()
    {
        return String.format("%s, %s", m_p1.toString(), m_p2.toString());
    }
}
