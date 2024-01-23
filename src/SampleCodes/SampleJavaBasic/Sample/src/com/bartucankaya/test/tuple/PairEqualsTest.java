package com.bartucankaya.test.tuple;

import org.csystem.collection.tuple.Pair;
import org.csystem.math.geometry.Point;
import org.csystem.util.console.Console;

public class PairEqualsTest {
    public static void run() {
        Point origin = Point.ofCartesian();

        Pair<Integer, Point> pair1 = new Pair<> (1, origin);
        Pair<Integer, Point> pair2 = new Pair<> (1, Point.ofCartesian(0, 0));

        Console.writeLine("Pair 1: %s%nPair 2: %s", pair1.toString(), pair2.toString());
        Console.writeLine(pair1.equals(pair2) ? "Same pair" : "Different pair");
    }

    public static void main(String[] args)
    {
        run();
    }
}
