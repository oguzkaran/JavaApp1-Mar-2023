package org.csystem.collection.tuple.test;

import org.csystem.collection.tuple.Pair;
import org.csystem.math.geometry.Point;
import org.csystem.util.collection.CollectionUtil;
import org.csystem.util.console.Console;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

public class PairConstructorTest {
    public static void run()
    {
        RandomGenerator random = new Random();
        ArrayList<Pair<Integer, Point>> points = new ArrayList<>();

        Point origin = Point.ofCartesian();
        int i = 1;
        while (true) {
            Point p = random.nextBoolean() ? Point.ofCartesian() : Point.ofCartesian(random.nextDouble(-100, 100), random.nextDouble(-100, 100));

            points.add(new Pair<>(i++, p));
            if (p.equals(origin))
                break;
        }

        Console.writeLine("Points:");
        CollectionUtil.print(points, "\n", "");
    }

    public static void main(String[] args)
    {
        run();
    }
}
