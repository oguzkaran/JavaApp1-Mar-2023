package org.csystem.math.geometry.test;

import org.csystem.math.geometry.Circle;
import org.csystem.util.console.Console;

import java.util.Random;

public class CircleEqualsTest {
    private static void run()
    {
        Circle c1 = new Circle(3.4);
        Circle c2 = new Circle(3.4);
        Circle c3 = new Circle(4.5);

        Console.writeLine(c1.equals(c2) ? "Aynı çember" : "Farklı çemberler");
        Console.writeLine(c1.equals(c3) ? "Aynı çember" : "Farklı çemberler");
    }

    public static void main(String[] args)
    {
        run();
    }
}
