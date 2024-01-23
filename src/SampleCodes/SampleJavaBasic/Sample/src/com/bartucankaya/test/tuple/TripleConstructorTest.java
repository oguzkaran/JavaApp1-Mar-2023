package com.bartucankaya.test.tuple;

import org.csystem.collection.tuple.Triple;
import org.csystem.math.geometry.Circle;
import org.csystem.math.geometry.Point;
import org.csystem.util.collection.CollectionUtil;
import org.csystem.util.console.Console;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

public class TripleConstructorTest {
    public static void run()
    {
        RandomGenerator random = new Random();
        ArrayList<Triple<Integer, Point, Circle>> pointsAndCircles = new ArrayList<>();

        Point origin = Point.ofCartesian();
        int i = 1;
        while (true) {
            Point p = random.nextBoolean() ? Point.ofCartesian() : Point.ofCartesian(random.nextDouble(-100, 100), random.nextDouble(-100, 100));
            Circle c = new Circle(random.nextDouble(0, 11));

            pointsAndCircles.add(new Triple<>(i++, p, c));
            if (p.equals(origin))
                break;
        }

        Console.writeLine("Points & Circles:");
        CollectionUtil.print(pointsAndCircles, "\n", "");
    }

    public static void main(String[] args)
    {
        run();
    }
}
