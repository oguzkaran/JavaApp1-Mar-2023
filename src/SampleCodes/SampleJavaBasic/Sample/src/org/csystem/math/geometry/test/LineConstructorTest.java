package org.csystem.math.geometry.test;

import org.csystem.math.geometry.Line;
import org.csystem.math.geometry.MutablePoint;

public class LineConstructorTest {
    public static void run()
    {
        Line line = new Line(100, 200, 300, 400);

        System.out.println(line.toString());

        MutablePoint p1 = line.getPoint1();

        p1.offset(20);

        System.out.println(p1.toString());
        System.out.println(line.toString());
    }

    public static void main(String[] args)
    {
        run();
    }
}
