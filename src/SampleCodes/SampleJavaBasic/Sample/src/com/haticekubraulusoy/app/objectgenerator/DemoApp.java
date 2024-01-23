package com.haticekubraulusoy.app.objectgenerator;

import org.csystem.math.geometry.Line;
import org.csystem.math.geometry.Point;
import org.csystem.util.array.ArrayUtil;
import org.csystem.util.generator.random.ObjectArrayGenerator;

import java.util.Scanner;

public class DemoApp {
    private static void doWorkFor(Object [] objects)
    {
        //String, IntValue, Point, MutableComplex, Line, int []
        for (Object object : objects) {
            System.out.println("-----------------------------------------------------------");
            String typeName = object.getClass().getName();
            System.out.printf("Dynamic type:%s%n", typeName);

            if (object instanceof String s)
                System.out.printf("Text:%s, upper:%s%n", s, s.toUpperCase());
            else if (object instanceof Integer) {
                int val = (int)object;

                System.out.printf("%d * %d = %d%n", val, val, val * val);
            }
            else if (object instanceof Point point)
                System.out.printf("Distance between %s and (0, 0):%f%n", point.toString(), point.distance());
            else if (object instanceof Line line) {
                Point midPoint = line.midPoint();

                System.out.printf("Mid point of %s is %s%n", line.toString(), midPoint.toString());
            }
            else if (object instanceof int[] a) {
                ArrayUtil.print(2, a);
                System.out.printf("Total:%d%n", ArrayUtil.sum(a));
            }
            else if (object instanceof Character) {
                char ch = (char)object;

                System.out.printf("ch = %c, ch = '\\u%04X'%n", ch, (int)ch);
            }
            else if (object instanceof Boolean) {
                boolean flag = (boolean)object;

                System.out.println(flag ? "Open" : "Closed");
            }
            System.out.println("-----------------------------------------------------------");
        }
    }

    public static void run()
    {
        ObjectArrayGenerator generator = new ObjectArrayGenerator();
        Scanner kb = new Scanner(System.in);

        System.out.print("Input count:");
        doWorkFor(generator.createObjects(kb.nextInt()));
    }

    public static void main(String[] args)
    {
        run();
    }
}
