package org.csystem.app.libraryusage;

import com.karandev.util.console.Console;
import org.csystem.math.geometry.Point;


import java.util.Random;

public class Application {
    public static void run(String [] args)
    {
        int count = Console.readInt("Input count:");
        Random random = new Random();

        while (count-- > 0) {
            Point p = Point.createCartesian(random.nextDouble(-10.234, 20.345), random.nextDouble(-10.234, 20.345));

            Console.writeLine(p);
        }
    }
}
