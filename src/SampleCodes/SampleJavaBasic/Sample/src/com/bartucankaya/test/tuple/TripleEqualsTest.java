package com.bartucankaya.test.tuple;

import org.csystem.collection.tuple.Triple;
import org.csystem.math.geometry.Circle;
import org.csystem.math.geometry.Point;
import org.csystem.util.console.Console;

public class TripleEqualsTest {
    public static void run() {
        Point origin = Point.ofCartesian();
        Circle unit = new Circle(1);

        Triple<Integer, Point, Circle> triple1 = new Triple<> (1, origin, unit);
        Triple<Integer, Point, Circle> triple2 = new Triple<> (1, Point.ofCartesian(0, 0), new Circle(1));

        Console.writeLine("Triple 1: %s%nTriple 2: %s", triple1.toString(), triple2.toString());
        Console.writeLine(triple1.equals(triple2) ? "Same triple" : "Different triple");
    }

    public static void main(String[] args)
    {
        run();
    }
}
