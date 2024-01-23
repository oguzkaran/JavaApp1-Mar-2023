package org.csystem.math.geometry.test;

import org.csystem.math.geometry.Circle;
import org.csystem.util.console.Console;

import java.util.Random;

public class CircleGetterSetterTest {
    private static void printCircle(Circle c)
    {
        Console.writeLine("Daire/çember bilgileri:");
        Console.writeLine("Yarıçap:%f", c.getRadius());
        Console.writeLine("Alan:%f", c.getArea());
        Console.writeLine("Çevre:%f", c.getCircumference());
    }

    private static void run()
    {
        Random random = new Random();
        Circle c = new Circle();

        int count = Console.readInt("Input count:");

        printCircle(c);

        while (count-- > 0) {
            Console.writeLine("--------------------------------------------------------------");
            try {
                double radius = random.nextDouble(-10, 10);

                Console.writeLine("Generated radius:%f", radius);
                c.setRadius(radius);
                printCircle(c);

            }
            catch (IllegalArgumentException ex) {
                Console.writeLine("Exception message:%s", ex.getMessage());
            }
            Console.writeLine("--------------------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
